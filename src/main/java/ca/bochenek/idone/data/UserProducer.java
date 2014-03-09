package ca.bochenek.idone.data;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ca.bochenek.idone.entity.User;

@Stateless
public class UserProducer {

	@Inject
	private EntityManager em;

	/** this is so bad that I can't believe that I am allowing myself to do this */
	public User login(String username, String password) {
		Query query = em.createQuery("select u from User u where username = :u");
		query.setParameter("u", username);
		User user = (User) query.getSingleResult();

		if (user != null && user.getPassword() != null
				&& user.getPassword().equals(hash(password))) {
			return user;
		} else {
			return null;
		}
	}
	
	public boolean isUsernameAlreadyUsed(String username) {
		Query query = em.createQuery("select u from User u where username = :u");
		query.setParameter("u", username);
		User user = (User) query.getSingleResult();
		return user != null;
	}
	
	public User create(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(hash(password));
		return update(user);
	}
	
	public User update(User user) {
		return em.merge(user);
	}

	private String hash(String input) {
		final String salt = "$*82xeDIWQ";
		String string = input + salt;
		StringBuffer result = new StringBuffer();

		try { 
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(string.getBytes(Charset.forName("UTF8")));
			final byte[] resultByte = messageDigest.digest();

			for (int i = 0; i < resultByte.length; ++i) {
				result.append(Integer.toHexString(
						(resultByte[i] & 0xFF) | 0x100).substring(1, 3));
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return result.toString();
	}

}
