package uk.ac.diamond.ispyb.dao;

import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.JdbcUtils;

import uk.ac.diamond.ispyb.api.DataCollectionPlanInfo;
import uk.ac.diamond.ispyb.api.ScanParameters;

public class DataCollectionPlanInfoListExtractor implements ResultSetExtractor<Collection<DataCollectionPlanInfo>> {
	@Override
	public Collection<DataCollectionPlanInfo> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		ResultSetMetaData metadata = resultSet.getMetaData();
		int columnCount = metadata.getColumnCount();
		
		Map<Integer, DataCollectionPlanInfo> plans = new HashMap<>();
		
		while (resultSet.next()){
			DataCollectionPlanInfo dataCollectionPlanInfo = getPlanForRow(resultSet, plans);
			populateBean(resultSet, metadata, columnCount, dataCollectionPlanInfo);
			
			ScanParameters scan = new ScanParameters();
			populateBean(resultSet, metadata, columnCount, scan);
			dataCollectionPlanInfo.addScanParameter(scan);
		}
		
		return plans.values();
	}

	private <T> void populateBean(ResultSet resultSet, ResultSetMetaData metadata, int columnCount, T bean) throws SQLException {
		BeanWrapper planWrapper = PropertyAccessorFactory.forBeanPropertyAccess(bean);
		for (int index = 1; index <= columnCount; index++) {
			String column = JdbcUtils.lookupColumnName(metadata, index);
			if (planWrapper.isWritableProperty(column)){
				PropertyDescriptor propertyDescriptor = planWrapper.getPropertyDescriptor(column);
				Object value = resultSet.getObject(index);
				planWrapper.setPropertyValue(propertyDescriptor.getName(), value);
			}
		}
	}

	private DataCollectionPlanInfo getPlanForRow(ResultSet resultSet, Map<Integer, DataCollectionPlanInfo> plans) throws SQLException {
		int id = resultSet.getInt("id");
		DataCollectionPlanInfo dataCollectionPlanInfo = plans.get(id);
		if (dataCollectionPlanInfo == null){
			dataCollectionPlanInfo = new DataCollectionPlanInfo();
			plans.put(id, dataCollectionPlanInfo);
		}
		return dataCollectionPlanInfo;
	}
}
