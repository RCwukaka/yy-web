package com.binghz.yy.utils;

import com.google.common.base.Joiner;

public class SqlJoiner {

	private SqlJoiner() {
		super();
	}

	private final static Joiner JOINER = Joiner.on("");

	public final static String join(String... strs) {
		return JOINER.join(strs);
	}
}
