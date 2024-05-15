package net.etfbl.webshop.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.etfbl.webshop.beans.AttributeBean;
import net.etfbl.webshop.beans.CategoryBean;
import net.etfbl.webshop.beans.AdminCustomerSupportBean;
import net.etfbl.webshop.beans.UserBean;
import net.etfbl.webshop.beans.StatisticsBean;
import net.etfbl.webshop.dto.Attribute;
import net.etfbl.webshop.dto.Category;
import net.etfbl.webshop.dto.User;



/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	
       
    /**
	 * 
	 */
	private static final long serialVersionUID = -6214087915165104955L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String address = "/WEB-INF/pages/login.jsp";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();

		session.setAttribute("notification", "");
		session.setAttribute("notificationOne", "");
		session.setAttribute("notificationTwo", "");
		session.setAttribute("notificationThree", "");
		session.setAttribute("notificationFour", "");
		session.setAttribute("notificationFive", "");
		session.setAttribute("notificationSix", "");
		session.setAttribute("notificationSeven", "");
		session.setAttribute("notificationEight", "");
		session.setAttribute("notificationNine", "");
		session.setAttribute("notificationTen", "");
		session.setAttribute("notificationEleven", "");

		
		if (action == null || action.equals("")) {
			
			
			
			address = "/WEB-INF/pages/login.jsp";
		}else if (action.equals("logout")) {
			session.invalidate();
			address = "/WEB-INF/pages/login.jsp";
		}else if (action.equals("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			AdminCustomerSupportBean adminSupportBean = new AdminCustomerSupportBean();
			if (adminSupportBean.login(username, password)) {
				session.setAttribute("adminSupportBean", adminSupportBean);
				CategoryBean categoryBean = new CategoryBean();
				session.setAttribute("categoryBean", categoryBean);
				UserBean userBean = new UserBean();
				session.setAttribute("userBean", userBean);
				
				AttributeBean attributeBean = new AttributeBean();
				session.setAttribute("attributeBean", attributeBean);
				StatisticsBean sBean = new StatisticsBean();
				session.setAttribute("statisticsBean", sBean);
				
				address = "/WEB-INF/pages/main.jsp";
			} else {
				session.setAttribute("notification", "Niste unijeli odgovarajuce parametre!");
			}
		} 
		
		else if (action.equals("categories")) {
			address = "/WEB-INF/pages/main.jsp";
			session.setAttribute("notification", "");
			
		}else if (action.equals("delete")) {

			CategoryBean kBean = (CategoryBean) session.getAttribute("categoryBean");
			/*address = "/WEB-INF/pages/main.jsp";
			
			
			if (request.getParameter("submit") != null) {*/
			
			
				/*try {
				      AbandonedConnectionCleanupThread.checkedShutdown();
				   } catch (Throwable t) {}
				*/
				   // This manually deregisters JDBC driver, which prevents Tomcat 7 from complaining about memory leaks
				   
				
				/*Enumeration<java .sql.Driver> drivers = java.sql.DriverManager.getDrivers();
				   while (drivers.hasMoreElements()) {
				      java.sql.Driver driver = drivers.nextElement();
				      try {
				         java.sql.DriverManager.deregisterDriver(driver);
				      } catch (Throwable t) {}
				   }
				   try { Thread.sleep(2000L); } catch (Exception e) {}
				*/
				
				
				try {
					String idKategorijeString = request.getParameter("idBrisati");
					int idKategorije = Integer.parseInt(idKategorijeString);
					
					if(kBean.delete(idKategorije)) {
						address = "/WEB-INF/pages/main.jsp";
						session.setAttribute("notification", "");
					}
					else {
						address = "/WEB-INF/pages/main.jsp";
						session.setAttribute("notification", "Kategorija ne moze biti obrisana!");
					}
					
				} catch (Exception e) {
					session.setAttribute("notification", "ERROR: " + e.getMessage());
				}
		}
		
		else if (action.equals("users")) {
			address = "/WEB-INF/pages/users.jsp";
			session.setAttribute("notification", "");
		} else if (action.equals("obrisiKorisnika")) {
			session.setAttribute("notification", "");
			UserBean kBean = (UserBean) session.getAttribute("userBean");
				try {
					String idKorisnikaString = request.getParameter("idBrisatiKorisnika");
					int idKorisnika = Integer.parseInt(idKorisnikaString);
					
					if(kBean.delete(idKorisnika)) {
						address = "/WEB-INF/pages/users.jsp";
						session.setAttribute("notification", "");
					}
					else {
						address = "/WEB-INF/pages/users.jsp";
						session.setAttribute("notificationEleven", "Korisnik ne moze biti obrisan!");
					}
					
				} catch (Exception e) {
					session.setAttribute("notificationEleven", "ERROR: " + e.getMessage());
				}
		}else if (action.equals("statistics")) {
			
			address = "/WEB-INF/pages/statistics.jsp";
		}else if (action.equals("newCategory")) {
			address = "/WEB-INF/pages/newCategory.jsp";
		}else if (action.equals("saveCategory")) {
			
			if(request.getParameter("naziv")!=null) {
				String naziv  = request.getParameter("naziv");
				
				try {
					if(naziv.length()<1) {
						session.setAttribute("notificationFive", "Unesite naziv kategorije!");
						address = "/WEB-INF/pages/novaKategorija.jsp";
					}
					else {
					
						CategoryBean kBean = (CategoryBean) session.getAttribute("categoryBean");
						Category k = new Category(naziv, null);
						
						if(kBean.insert(k)) {
							address = "/WEB-INF/pages/main.jsp";
						}
					}
					
				}catch (Exception e) {
					session.setAttribute("notificationFive", "ERROR: " + e.getMessage());
				}
					
					
			}else {
				session.setAttribute("notificationOne", "Unesite naziv kategorije!");
			}
		}else if (action.equals("newUser")) {
			address = "/WEB-INF/pages/newUser.jsp";
		}else if (action.equals("saveUser")) {
			session.setAttribute("notificationThree", "");
			boolean postoji=false;
			
			if(request.getParameter("ime")!="" && request.getParameter("prezime")!="" && request.getParameter("grad")!=""
					&& request.getParameter("kor_ime")!="" && request.getParameter("lozinka")!=""
					&& request.getParameter("mail")!="")  {
				
				
				
				String ime  = request.getParameter("ime");
				String prezime  = request.getParameter("prezime");
				String grad  = request.getParameter("grad");
				String kor_ime  = request.getParameter("kor_ime");
				String lozinka  = request.getParameter("lozinka");
				String mail  = request.getParameter("mail");
				
				try {
					UserBean kBean = (UserBean) session.getAttribute("userBean");
					
					if(kBean.usersExists(request.getParameter("kor_ime"))) {
						postoji=true;
					}
					
					if(!postoji) {
						
					
					
						String pin ="";
						for(int i = 0; i < 4; i++) {
							pin += new Random().nextInt(9)+1;
						}
						
						
						User k = new User(ime, prezime, grad, kor_ime, lozinka, mail , null, pin);
						
						
						if(kBean.insert(k)) {
							address = "/WEB-INF/pages/users.jsp";
						}
					
					}
					else {
						
						session.setAttribute("notificationThree", "Postoji korisnik sa zeljenim korisnickim imenom!");
						address = "/WEB-INF/pages/newUser.jsp";
					}
					
				}catch (Exception e) {
					session.setAttribute("notificationThree", "ERROR: " + e.getMessage());
				}
					
					
			}else {
				
				session.setAttribute("notificationThree", "Niste popunili sva polja!");
				address = "/WEB-INF/pages/newUser.jsp";
			}
		} else if(action.equals("update")) {
			CategoryBean kBean = (CategoryBean) session.getAttribute("categoryBean");
			String idKategorijeString = request.getParameter("idIzmjena");
			int idKategorije = Integer.parseInt(idKategorijeString);
			
			Category k = kBean.getCategoryById(idKategorije);
			session.setAttribute("nazivKategorije", k.getName());
			session.setAttribute("idKategorije", k.getId());
			
			address = "/WEB-INF/pages/updateCategory.jsp";
		}else if(action.equals("saveUpdatedCategory")) {
			CategoryBean kBean = (CategoryBean) session.getAttribute("categoryBean");
			String noviNaziv = request.getParameter("naziv");
			int id = Integer.parseInt(request.getParameter("id"));
			
			if(noviNaziv.length()<1) {
				session.setAttribute("notificationSix", "Unesite naziv kategorije");
				address = "/WEB-INF/pages/updateKategorija.jsp"; 
			}
			
			else {
			Category k = new Category(id, noviNaziv, null);
			kBean.update(k);
			
			address = "/WEB-INF/pages/main.jsp";
			}
		}else if(action.equals("updateUser")) {
			UserBean kBean = (UserBean) session.getAttribute("userBean");
			int id  = Integer.parseInt(request.getParameter("idIzmjenaKorisnika"));
			
			User k = kBean.getUserById(id);
			
			session.setAttribute("idKorisnikaa", k.getId());
			session.setAttribute("imee", k.getFist_name());
			session.setAttribute("prezimee", k.getLast_name());
			session.setAttribute("kor_imee", k.getUsername());
			session.setAttribute("lozinkaa", k.getPassword());
			session.setAttribute("gradd", k.getCity());
			session.setAttribute("maill", k.getMail());
			
			address = "/WEB-INF/pages/updateUser.jsp";
			
		}else if(action.equals("saveUpdatedUser")) {
			UserBean kBean = (UserBean) session.getAttribute("userBean");
			String novoIme = request.getParameter("ime");
			String novoPrezime = request.getParameter("prezime");
			String novoKorIme = request.getParameter("kor_ime");
			String novaLozinka = request.getParameter("lozinka");
			String noviGrad = request.getParameter("grad");
			String noviMail = request.getParameter("mail");
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			User k = new User(id, novoIme, novoPrezime, noviGrad, novoKorIme, novaLozinka, noviMail);
			
			String staroIme  = request.getParameter("staroIme");
			
			boolean prazno = false;
			
			if(novoIme.equals("") || novoPrezime.equals("") || 
					noviGrad.equals("") || novoKorIme.equals("") ||
					novaLozinka.equals("") || noviMail.equals(""))  
				{
				prazno = true;
				session.setAttribute("notificationFour", "Niste popunili sva polja!");
				address = "/WEB-INF/pages/updateUser.jsp";
			}
			
			if(staroIme.equals(novoKorIme) && !prazno) {
				kBean.update(k);
				address = "/WEB-INF/pages/users.jsp"; //radi
				
			}
			else if (!staroIme.equals(novoKorIme) && !kBean.usersExists(novoKorIme) && !prazno){
				kBean.update(k);
				address = "/WEB-INF/pages/users.jsp";
			}else if (!staroIme.equals(novoKorIme) && kBean.usersExists(novoKorIme) && !prazno){
				session.setAttribute("notificationFour", "Postoji korisnik sa zeljenim korisnickim imenom!");
				address = "/WEB-INF/pages/updateUser.jsp";
			}
			
			
			else {
				address = "/WEB-INF/pages/updateUser.jsp";
			}
		}else if (action.equals("deleteSpecific")) {

			CategoryBean kBean = (CategoryBean) session.getAttribute("categoryBean");
			//SpecificnaKategorijaBean kBean = (SpecificnaKategorijaBean) session.getAttribute("specKategorijaBean");
			/*address = "/WEB-INF/pages/main.jsp";
			
			
			if (request.getParameter("submit") != null) {*/
			
			
				/*try {
				      AbandonedConnectionCleanupThread.checkedShutdown();
				   } catch (Throwable t) {}
				*/
				   // This manually deregisters JDBC driver, which prevents Tomcat 7 from complaining about memory leaks
				   
				
				/*Enumeration<java .sql.Driver> drivers = java.sql.DriverManager.getDrivers();
				   while (drivers.hasMoreElements()) {
				      java.sql.Driver driver = drivers.nextElement();
				      try {
				         java.sql.DriverManager.deregisterDriver(driver);
				      } catch (Throwable t) {}
				   }
				   try { Thread.sleep(2000L); } catch (Exception e) {}
				*/
				
				
				try {
					String idKategorijeString = request.getParameter("idBrisatiSpec");
					int idKategorije = Integer.parseInt(idKategorijeString);
					
					if(kBean.delete(idKategorije)) {
						address = "/WEB-INF/pages/main.jsp";
						session.setAttribute("notificationOne", "");
					}
					else {
						address = "/WEB-INF/pages/main.jsp";
						session.setAttribute("notificationOne", "Specificna kategorija ne moze biti obrisana!");
					}
					
				} catch (Exception e) {
					session.setAttribute("notificationOne", "ERROR: " + e.getMessage());
				}
		} else if(action.equals("updateSpec")) {
			
			CategoryBean kBean = (CategoryBean) session.getAttribute("categoryBean");
			//SpecificnaKategorijaBean kBean = (SpecificnaKategorijaBean) session.getAttribute("specKategorijaBean");
			String idKategorijeString = request.getParameter("idIzmjenaSpec");
			int idKategorije = Integer.parseInt(idKategorijeString);
			
			Category k = kBean.getSubCategoryById(idKategorije);
			session.setAttribute("nazivSpecKategorije", k.getName());
			session.setAttribute("idSpecKategorije", k.getId());
			session.setAttribute("idKategorije", k.getParentCategoryId());
			//session.setAttribute("nazivKat", k.getKategorija().getNaziv());
			
			address = "/WEB-INF/pages/updateSpecCategory.jsp";
		}else if(action.equals("saveUpdatedCategory")) {
			CategoryBean kBean = (CategoryBean) session.getAttribute("categoryBean");
			
			//SpecificnaKategorijaBean kBean = (SpecificnaKategorijaBean) session.getAttribute("specKategorijaBean");
			String noviNaziv = request.getParameter("naziv");
			int id = Integer.parseInt(request.getParameter("id"));
			
			if(noviNaziv.length()<1) {
				session.setAttribute("notificationTen", "Unesite naziv specificne kategorije!");
				address = "/WEB-INF/pages/updateSpecCategory.jsp";
			}
			
			else {
				Category k =new Category(id, noviNaziv, Integer.parseInt(request.getParameter("idKategorije")));
			//SpecificnaKategorija k = new SpecificnaKategorija(id, noviNaziv, new Category(Integer.parseInt(request.getParameter("idKategorije")), request.getParameter("nazivKat")));
			kBean.update(k);
			
			address = "/WEB-INF/pages/main.jsp";
			}
			
		}else if (action.equals("newSpecific")) {
			address = "/WEB-INF/pages/newSpecificCategory.jsp";
		}else if (action.equals("saveSpecific")) {
			
			if(request.getParameter("naziv")!=null) {
				String naziv  = request.getParameter("naziv");
				
				
					if(naziv.length()<1) {
						session.setAttribute("notificationNine", "Unesite naziv specificne kategorije!");
						address = "/WEB-INF/pages/novaSpecKategorija.jsp";
					}
					else {
						try {
						int idKategorije = Integer.parseInt(request.getParameter("combobox"));
						CategoryBean kBean = (CategoryBean) session.getAttribute("categoryBean");
						Category kat = kBean.getCategoryById(idKategorije);
						
						//Category skBean = (Category) session.getAttribute("specKategorijaBean");
						Category sk = new Category(naziv, kat.getId());
						
						
						
						if(kBean.insert(sk)) {
							address = "/WEB-INF/pages/main.jsp";
						}
					}catch (Exception e) {
						session.setAttribute("notificationNine", "ERROR: " + e.getMessage());
					}
					
				}
					
					
			}else {
				session.setAttribute("notificationOne", "Unesite naziv kategorije!");
			}
		}else if (action.equals("newAttribute")) {
			address = "/WEB-INF/pages/newAttribute.jsp";
		}else if (action.equals("saveAttribute")) {
			
			
				String naziv  = request.getParameter("naziv");
				
				
					if(naziv.length()<1) {
						session.setAttribute("notificationSeven", "Unesite naziv atributa!");
						address = "/WEB-INF/pages/newAttribute.jsp";
					}
					else {
						try {
					
						int idSpecKategorije = Integer.parseInt(request.getParameter("combobox"));
						System.out.println(idSpecKategorije);
						CategoryBean skBean = (CategoryBean) session.getAttribute("categoryBean");
						AttributeBean aBean = (AttributeBean) session.getAttribute("attributeBean");
						Category sk = skBean.getSubCategoryById(idSpecKategorije);
						
						Attribute aa = new Attribute(naziv, sk);
						
						if(aBean.insert(aa)) {
							address = "/WEB-INF/pages/main.jsp";
						}
					}catch (Exception e) {
						session.setAttribute("notificationSeven", "ERROR: " + e.getMessage());
						address = "/WEB-INF/pages/newAttribute.jsp";
					}
					
				}
					
					
			
		}else if (action.equals("deleteAttribute")) {

			AttributeBean aBean = (AttributeBean) session.getAttribute("attributeBean");				
				try {
					String idAtributa = request.getParameter("idBrisatiAtribut");
					int id = Integer.parseInt(idAtributa);
					
					if(aBean.delete(id)) {
						address = "/WEB-INF/pages/main.jsp";
						session.setAttribute("notificationTwo", "");
					}
					else {
						address = "/WEB-INF/pages/main.jsp";
						session.setAttribute("notificationTwo", "Atribut ne moze biti obrisan!");
					}
					
				} catch (Exception e) {
					session.setAttribute("notificationTwo", "ERROR: " + e.getMessage());
				}
		}else if(action.equals("updateAttribute")) {
			AttributeBean aBean = (AttributeBean) session.getAttribute("attributeBean");
			int idAtributa = Integer.parseInt(request.getParameter("idIzmjenaAtributa"));
			
			Attribute atribut = aBean.getAtributById(idAtributa);
			
			session.setAttribute("nazivAtributa", atribut.getName());
			session.setAttribute("idAtributa", idAtributa);
			session.setAttribute("nazivSpecKategorije", atribut.getCategory().getName());
			session.setAttribute("idSpecKategorije", atribut.getCategory().getId());
			session.setAttribute("idParentKategorije", atribut.getCategory().getParentCategoryId());
			
			address = "/WEB-INF/pages/updateAttribute.jsp";
		}else if(action.equals("saveUpdatedAttribute")) {
			AttributeBean aBean = (AttributeBean) session.getAttribute("attributeBean");
			
			
			String noviNaziv = request.getParameter("naziv");
			int id = Integer.parseInt(request.getParameter("idAtributa"));
			
			if(noviNaziv.length()<1) {
				session.setAttribute("notificationEight", "Unesite naziv atributa");
				address = "/WEB-INF/pages/updateAtribut.jsp";
			}
			else {
			Attribute a = new Attribute(id, noviNaziv,new Category(Integer.parseInt(request.getParameter("idSpecKategorije")), request.getParameter("nazivSpecKategorije"), Integer.parseInt(request.getParameter("idParentKategorije"))));
			aBean.update(a);
			
			address = "/WEB-INF/pages/main.jsp";
			}
		}
		
		
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
