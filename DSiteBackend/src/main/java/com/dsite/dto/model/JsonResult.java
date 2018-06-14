package com.dsite.dto.model;

public class JsonResult {

    private String codigo = "";
    
    public JsonResult(String codigo) {
        this.codigo = codigo;
    }

    public JsonResult() {
    }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
