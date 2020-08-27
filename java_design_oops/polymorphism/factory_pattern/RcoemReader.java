package rcoem;
import java.util.ArrayList;
import java.io.InputStream;

public interface RcoemReader{
		public void print();
		public boolean initialize();
		public void setInputStream(InputStream in);
}