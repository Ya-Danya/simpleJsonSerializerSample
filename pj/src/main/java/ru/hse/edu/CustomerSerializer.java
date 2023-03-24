package ru.hse.edu;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CustomerSerializer implements JsonSerializer<Customer> {
    @Override
    public JsonElement serialize(Customer src, Type typeOfSrc, JsonSerializationContext context) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> dish = src.getDish();
        String vis_name = src.getVis_name();
        list.add(vis_name);
        return new JsonPrimitive(
                new StringBuilder(src.getColor())
                        .append(" ")
                        .append(StringUtils.join(list, " and "))
                        .toString()
        );
    }
}
