package com.example.model;

public class Usuario {
	
	private Long id;
    private String name;
    private String email;
    private String dataCadastro;
    private String company;
    private String city;
    private String region;
    private String country;
    private String postalZip;
    
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String name, String email, String dataCadastro, String company, String city, String region,
			String country, String postalZip) {
		super();
		this.name = name;
		this.email = email;
		this.dataCadastro = dataCadastro;
		this.company = company;
		this.city = city;
		this.region = region;
		this.country = country;
		this.postalZip = postalZip;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalZip() {
		return postalZip;
	}
	public void setPostalZip(String postalZip) {
		this.postalZip = postalZip;
	}

	@Override
	public String toString() {
		return "Usuario [name=" + name + ", email=" + email + ", dataCadastro=" + dataCadastro + ", company=" + company
				+ ", city=" + city + ", region=" + region + ", country=" + country + ", postalZip=" + postalZip + "]";
	}

}
