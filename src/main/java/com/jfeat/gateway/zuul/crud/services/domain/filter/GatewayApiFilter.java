package com.jfeat.gateway.zuul.crud.services.domain.filter;


import com.jfeat.crud.plus.CRUDFilter;
import com.jfeat.gateway.zuul.crud.services.gen.persistence.model.GatewayApi;

/**
 * Created by Code Generator on 2020-05-25
 */
public class GatewayApiFilter implements CRUDFilter<GatewayApi> {

    private String[] ignoreFields = new String[]{};
    private String[] updateIgnoreFields = new String[]{};

    @Override
    public void filter(GatewayApi entity, boolean insertOrUpdate) {

        //if insertOrUpdate is true,means for insert, do this
        if (insertOrUpdate){

            //then insertOrUpdate is false,means for update,do this
        }else {

        }

    }

    @Override
    public String[] ignore(boolean retrieveOrUpdate) {
        //if retrieveOrUpdate is true,means for retrieve ,do this
        if (retrieveOrUpdate){
            return ignoreFields;
            //then retrieveOrUpdate  if false ,means for update,do this
        }else {
            return updateIgnoreFields;
        }
    }
}
