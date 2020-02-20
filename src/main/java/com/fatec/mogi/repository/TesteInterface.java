//package com.fatec.mogi.DAO;
//
//@Service
//public interface UserDao extends JpaRepository<User, Long>, IDao{	
//}
//
//public interface ShowDao extends JpaRepository<Show, Long>, IDao{
//}

//@Query("SELECT user FROM User user WHERE user.email = :email AND user.senha = ?2")
//Optional<User> login(@Param("email")String email, String senha);

//public interface ShowDao{
//}
//
//@Service
//public class xxx implements ShowDao{
//	
//}

//public class facade {
	
//	@Autowired
//	Map<String, IDao> daos;
	
//	@Autowired
//	ShowDao dao;
//	
//	facade(){
//		daos.put("UserDao", new UserDao());
//	}
//	
//	save(DomainEntity x){
//		daos.get(x.getSimpleName() + "Dao").save(x);
//	}
//	
//}

