//package com.ejemplos.security;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.ejemplos.models.entity.Medico;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//	
//	private JwtUtils jwtUtils;
//	
//	public JwtAuthenticationFilter(JwtUtils jwtUtils) {
//		this.jwtUtils=jwtUtils;
//	}
//	
//	public Authentication attempAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException{
//		Medico userEntity=null;
//		String username="";
//		String password="";
//		try {
//			userEntity=new ObjectMapper().readValue(request.getInputStream(),Medico.class);
//			username=userEntity.getNumeroIdentificacion();
//			password=userEntity.getPass();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(username,password);
//		return getAuthenticationManager().authenticate(authenticationToken);
//	}
//	
//	
//	protected void SuccessfulAuthentication(HttpServletRequest request,HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException{
//		User user=(User)authResult.getPrincipal();
//		String token=jwtUtils.generateAccessToken(user.getUsername());
//		response.addHeader("Authorizaztion",token);
//		Map<String,Object> httpResponse=new HashMap<>();
//		httpResponse.put("token",token);
//		httpResponse.put("Message","Autenticación Correcta");
//		httpResponse.put("Username",user.getUsername());
//	
//		response.getWriter().write(new ObjectMapper().writeValueAsString(httpResponse));
//		response.setStatus(HttpStatus.OK.value());
//		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//		response.getWriter().flush();
//		
//		
//		super.successfulAuthentication(request,response,chain,authResult);
//	}
//	
//}
