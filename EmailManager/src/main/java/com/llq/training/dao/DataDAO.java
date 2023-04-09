package com.llq.training.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.llq.training.entity.EmailEntity;

public class DataDAO {
	private final Connection connection;

	  public DataDAO(Connection connection) {
	    this.connection = connection;
	  }

	public List<EmailEntity> getData(String ma, int page, int pageSize) throws SQLException {
	    List<EmailEntity> dataList = new ArrayList<>();

	    try (CallableStatement statement = connection.prepareCall("{ call get_data(?,?,?) }")) {
	      statement.setString(1, ma);
	      statement.setInt(2, page);
	      statement.setInt(3, pageSize);

	      ResultSet resultSet = statement.executeQuery();
	      while (resultSet.next()) {
	        EmailEntity data = new EmailEntity();
	        data.setId(resultSet.getLong("ID"));
	        data.setMa(resultSet.getString("MA"));
	        data.setNoi_dung(resultSet.getString("NOI_DUNG"));
	        data.setNguoi_tao(resultSet.getString("NGUOI_TAO"));
	        data.setNgay_tao(resultSet.getDate("NGAY_TAO"));
	        data.setNguoi_sua(resultSet.getString("NGUOI_SUA"));
	        data.setNgay_sua(resultSet.getDate("NGAY_SUA"));
	        dataList.add(data);
	      }
	    }

	    return dataList;
	  }
}
