package fr.formation.security;

//public class UserPrincipal implements UserDetails
//{
//	private Compte compte;
//	
//	public UserPrincipal(Compte compte)
//	{
//		if(compte ==null )
//		{
//			throw new UsernameNotFoundException("Le compte n'existe pas.");
//		}
//		this.compte=compte;
//	}
//	
//	public String spec()
//	{
//		return "Sp�cificit�s";
//	}
//	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() 
//	{
//		List<GrantedAuthority> roles = new ArrayList<>();
//	
//		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
//		
//		return roles;
//	}
//
//	@Override
//	public String getPassword() {
//	
//		return this.compte.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//	
//		return this.compte.getLogin();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//	
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	
//}