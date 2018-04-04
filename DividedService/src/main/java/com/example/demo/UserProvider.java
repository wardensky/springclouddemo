package com.example.demo;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class UserProvider {

	public static final String TABLE = "user";
	
	public String selByN4N5(@Param("n4")String n4, @Param("n5")String n5) {
        SQL sql = new SQL().SELECT("id, n1, n2, n3, n4, n5, n6, create_time createTime").FROM(TABLE);
        if (StringUtils.isNotBlank(n4)) {
            sql.WHERE(" n4 = #{n4} ");
        }
        if (StringUtils.isNotBlank(n5)) {
        	sql.WHERE(" n5 = #{n5} ");
        }
        return sql.toString();
    }
}
