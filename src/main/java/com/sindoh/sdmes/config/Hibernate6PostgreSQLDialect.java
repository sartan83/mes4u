package com.sindoh.sdmes.config;

import java.sql.Types;

import org.hibernate.dialect.PostgreSQLDialect;

public class Hibernate6PostgreSQLDialect extends PostgreSQLDialect {

	@Override
	public boolean equivalentTypes(int typeCode1, int typeCode2) {
		return super.equivalentTypes(typeCode1, typeCode2)
				|| isNumeric(typeCode1) && isNumeric(typeCode2)
				|| isTemporal(typeCode1) && isTemporal(typeCode2)
				|| isText(typeCode1) && isText(typeCode2);
	}

	private boolean isNumeric(int typeCode) {
		return typeCode == Types.BIGINT
				|| typeCode == Types.DECIMAL
				|| typeCode == Types.INTEGER
				|| typeCode == Types.NUMERIC
				|| typeCode == Types.SMALLINT;
	}

	private boolean isTemporal(int typeCode) {
		return typeCode == Types.DATE
				|| typeCode == Types.TIME
				|| typeCode == Types.TIMESTAMP;
	}

	private boolean isText(int typeCode) {
		return typeCode == Types.CHAR
				|| typeCode == Types.LONGVARCHAR
				|| typeCode == Types.VARCHAR;
	}
}
