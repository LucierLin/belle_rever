package manager.orderManager.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.text.TabExpander;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import home.purchase.model.CouponBean;
import home.purchase.model.OrderBean;
import home.purchase.model.OrderValBean;
import manager.itemManager.model.ItemValBean;

@Repository("OrdManagerDaoImpl")
@Transactional
public class OrdManagerDaoImpl implements OrdManagerDao {
	@Resource(name = "template")
	JdbcTemplate template;

	public OrdManagerDaoImpl() {
	};

	public OrdManagerDaoImpl(JdbcTemplate template) {
		super();
		this.template = template;
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<OrderBean> getOrd(Short osId) {
		String sql = "Select *  from ord where osid = ?";
		List<OrderBean> obList = new ArrayList<>();
		obList = template.query(sql, new Object[] { osId }, new BeanPropertyRowMapper<OrderBean>(OrderBean.class));
		if (obList.isEmpty()) {
			return null;
		}

		return obList;
	}

	@Override
	public List<OrderValBean> getOrdVal(Integer ordId) {
		String sql = " SELECT   o.isFeedBack, o.ordid , o.ordSerialNumber , i.itemId , o.ordQty , v.itemSerialNumber ,v.itemColor, "
				+ " i.itemPrice,v.itemSize,i.itemHeader,i.itemPic1,i.itemDiscount,v.itemQty "
				+ " FROM ord_val o JOIN item i  ON i.itemId = o.itemId "
				+ " JOIN item_val v ON  o.itemSerialNumber = v.itemSerialNumber AND o.itemId =v.itemId "
				+ " WHERE o.ordid =? ";

		List<OrderValBean> obList = new ArrayList<>();
		obList = template.query(sql, new Object[] { ordId },
				new BeanPropertyRowMapper<OrderValBean>(OrderValBean.class));
		if (obList.isEmpty()) {
			return null;
		}
		return obList;
	}

	@Override
	public OrderBean getAOrd(Integer ordId) {
		String sql = "Select *  from ord where ordId = ?";
		List<OrderBean> obList = new ArrayList<>();
		obList = template.query(sql, new Object[] { ordId }, new BeanPropertyRowMapper<OrderBean>(OrderBean.class));
		if (obList.isEmpty()) {
			return null;
		}
		return obList.get(0);
	}

	@Override
	public void upadteOrdValQty(Integer ordId, Short ordSerN, Short qty) {
		String sql = "Update ord_val set ordQty = ?  where ordid = ? and ordSerialNumber =?";
		template.update(sql, qty, ordId, ordSerN);

	}

	@Override
	public void updateOrdTotal(Integer ordId, Integer ordTotal) {
		String sql = "Update ord  set ordTotal = ?  where ordid = ? ";
		template.update(sql, ordTotal, ordId);

	}

	@Override
	public void deleteOV(Integer ordid, Short ordSerialNumber) {
		String sql = "Delete from ord_val  where ordid = ? and ordSerialNumber= ? ";
		template.update(sql, ordid, ordSerialNumber);
	}

	@Override // 修改訂單編號
	public void upadteOrdValSern(List<OrderValBean> ovbL) {
		String sql = "Delete from ord_val where ordid = ?  ";
		template.update(sql,ovbL.get(0).getOrdId());
		sql = "insert into ord_val (Ordid,OrdSerialNumber,Itemid,Ordqty,itemSerialNumber,Itemcolor,Itemprice,Itemsize,Itemheader,Itempic1) "
				+ " values (?,?,?,?,?,?,?,?,?,?);";
		for(OrderValBean o :ovbL){
			template.update(sql,ovbL.get(0).getOrdId(),o.getOrdSerialNumber(),o.getItemId(),o.getOrdQty(),o.getItemSerialNumber(),o.getItemColor(),o.getItemPrice(),o.getItemSize(),o.getItemHeader(),o.getItemPic1());
		}
	}

	@Override//修改刪除訂單商品後 該商品的數量
	public void updateItemQty(OrderValBean o) {
		String sql = "Select * from item_val where Itemid = ? and itemSerialNumber= ? ";
		List<ItemValBean> ibL = template.query(sql, new Object[] { o.getItemId(), o.getItemSerialNumber() },
				new BeanPropertyRowMapper<ItemValBean>(ItemValBean.class));
		if(ibL!=null){
		sql = "Update item_val set Itemqty = ? ,Itemsold = ? where Itemid = ? and itemSerialNumber= ? ";
		Integer soldQty = ibL.get(0).getItemSold()-o.getOrdQty();
		Integer itemQty = ibL.get(0).getItemQty()+o.getOrdQty();
		template.update(sql,itemQty,soldQty,o.getItemId(),o.getItemSerialNumber());
		}
	}

	
	@Override
	public void deleteOVItem(List<OrderValBean> ovbL, Integer ordTotal, OrderValBean updateItemQty) {
		deleteOV( updateItemQty.getOrdId(),updateItemQty.getOrdSerialNumber() );
		upadteOrdValSern(ovbL);
		updateItemQty(updateItemQty);
		System.out.println(ordTotal);
		updateOrdTotal(updateItemQty.getOrdId(), ordTotal);
	}

	@Override//商品清單內為空   刪掉訂單
	public void deleteOrd(Integer ordid,OrderValBean o) {
		updateItemQty(o);
		String 	sql = "Delete from ord_val where ordid =  ?";
		template.update(sql,ordid);
		sql = "Delete from ord where ordid =  ?";
		template.update(sql,ordid);
	}

	@Override
	public CouponBean checkCoupon(String cpid) {
		String sql ="select * from coupon where cpid = ?";
		List<CouponBean> coupList =template.query(sql ,new Object[]{cpid} ,  new BeanPropertyRowMapper<CouponBean>(CouponBean.class));
		if(coupList.isEmpty()){
			return null;
		}
		return coupList.get(0);
		
	}

	@Override
	public void updateOrd(OrderBean ob) {
		String sql ="update ord set shipDate= ?,cpId=?,osId=?,ordTotal=? where ordId= ?";
		template.update(sql,ob.getShipDate(),ob.getCpId(),ob.getOsId(),ob.getOrdTotal(),ob.getOrdId());
	}
	
	
	
	

}
