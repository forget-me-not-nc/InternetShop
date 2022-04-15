package com.example.internetshop.configurations;

import org.hibernate.boot.model.relational.Namespace;
import org.hibernate.boot.model.relational.Sequence;
import org.hibernate.mapping.Table;
import org.hibernate.tool.schema.spi.SchemaFilter;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.SchemaFilter
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 11.04.2022|0:53
 * @Version SchemaFilter: 1.0
 */

public class CustomSchemaFilter implements SchemaFilter {

    public static final CustomSchemaFilter INSTANCE = new CustomSchemaFilter();

    @Override
    public boolean includeNamespace(Namespace namespace) {
        return true;
    }

    @Override
    public boolean includeTable(Table table) {
        return !table.getName().equals("orders") &&
                !table.getName().equals("accounts") &&
                !table.getName().equals("clients") &&
                !table.getName().equals("users");
    }

    @Override
    public boolean includeSequence(Sequence sequence) {
        return true;
    }
}