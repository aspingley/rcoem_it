package rcoem;

class rcoemStaticSample{
		private static int m_count = 1;
		public String getStatus(){
				return "Status for rcoemStaticSample is OK: " +  String.valueOf(m_count);
		}
		public void update(){
				++m_count;			
		}
}


public class rcoemSingleton{
		private static rcoemSingleton m_instance;
		private String m_status;
		private int m_count;

		public String getStatus(){
				return m_status;
		}

		private rcoemSingleton(){
				m_instance = null;
				m_status = "Status for rcoemSingleton is OK: " +  String.valueOf(++m_count);
		}

		public static rcoemSingleton getInstance(){
				if (null == m_instance){
						m_instance = new rcoemSingleton();
				}
				return m_instance;
		}

		public void update(){
				m_status = "Status for rcoemSingleton is OK: " +  String.valueOf(++m_count);
		}

		public static void main(String args[]){
				rcoemStaticSample s1 = new rcoemStaticSample();
				System.out.println("status = " + s1.getStatus());
				
				rcoemStaticSample s2 = new rcoemStaticSample();
				System.out.println("status = " + s2.getStatus());
			
				s1.update();
				s2.update();	
				System.out.println("status = " + s1.getStatus());
				System.out.println("status = " + s2.getStatus());
					
				rcoemSingleton ms = rcoemSingleton.getInstance();
				System.out.println("status = " + rcoemSingleton.getInstance().getStatus());
				rcoemSingleton copyMs = ms;
				System.out.println("status = " + copyMs.getStatus());
				ms.update();
				System.out.println("status = " + ms.getStatus());
				copyMs.update();
				System.out.println("status = " + copyMs.getStatus());
				copyMs.update();
				copyMs.update();
				copyMs.update();
				System.out.println("status = " + copyMs.getStatus());
				System.out.println("status = " + ms.getStatus());
				System.out.println("status = " + rcoemSingleton.getInstance().getStatus());
		}
}