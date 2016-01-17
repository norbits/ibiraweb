package br.com.ibiraweb.util;


import java.io.Serializable;

public class UserInfo implements Serializable
{

 private String nome;
 private String apelido;
 private String senha;
 private String role;
 
 
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getApelido() {
	return apelido;
}
public void setApelido(String apelido) {
	this.apelido = apelido;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
 
 
 
 

}