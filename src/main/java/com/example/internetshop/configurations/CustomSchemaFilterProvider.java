package com.example.internetshop.configurations;

import org.hibernate.tool.schema.spi.SchemaFilter;
import org.hibernate.tool.schema.spi.SchemaFilterProvider;

/**
 * Created by IntelliJ IDEA.
 * InternetShop.CustomSchemaFilterProvider
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 11.04.2022|0:54
 * @Version CustomSchemaFilterProvider: 1.0
 */

public class CustomSchemaFilterProvider implements SchemaFilterProvider {

    @Override
    public SchemaFilter getCreateFilter() {
        return CustomSchemaFilter.INSTANCE;
    }

    @Override
    public SchemaFilter getDropFilter() {
        return CustomSchemaFilter.INSTANCE;
    }

    @Override
    public SchemaFilter getMigrateFilter() {
        return CustomSchemaFilter.INSTANCE;
    }

    @Override
    public SchemaFilter getValidateFilter() {
        return CustomSchemaFilter.INSTANCE;
    }
}