package com.gpl.rpg.AndorsTrail.resource.parsers.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class JsonArrayParserFor<T> extends JsonParserFor<T> {
	private final Class<T> classType;

	public JsonArrayParserFor(Class<T> classType) {
		if (classType == null) throw new IllegalArgumentException("classType for parseArray must not be null");
		this.classType = classType;
	}

	public T[] parseArray(JSONArray array) throws JSONException {
		if (array == null) return null;
		final ArrayList<T> arrayList = new ArrayList<T>(array.length());
		parseRows(array, arrayList);
		if (arrayList.isEmpty()) return null;
		return arrayList.toArray((T[]) Array.newInstance(classType, arrayList.size()));
	}
}
