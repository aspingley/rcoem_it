package rcoem;

public class RcoemEmployee{
		private String _name;
		private String _title;
		private String _id;
		public void setName(String name){
				_name = name;
		}
		public void setTitle(String title){
				_title = title;
		}
		public String getName(){
				return _name;		
		}
		public String getTitle(){
				return _title;
		}
		public void setId(String id){
				_id = id;
		}
		public String getId(){
				return _id;
		}
}