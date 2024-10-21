package com.ConversorDeMoneda.principal;

public record TipoDeCambio(String result,
                           String base_code,
                           String target_code,
                           Double conversion_rate,
                           Double conversion_result){
}
