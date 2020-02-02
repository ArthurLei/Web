package servlet;
import dao.Bookcon;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
//@WebServlet(name = "BookAdd")
public class BookAdd extends HttpServlet {
    public static String filename = null;
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String BookID=null;
        String Bookname=null;
        String author=null;
        String price=null;
        String intro=null;
      //  System.out.println(BookID+" "+Bookname+" "+author+" "+price+" "+intro);
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 创建文件上传处理器
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 开始解析请求信息
        factory.setSizeThreshold(1024 * 1024);
        List items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        Iterator iter = items.iterator();
        while(iter.hasNext()){
            FileItem item = (FileItem) iter.next();
            if (item.isFormField()){
                String S=item.getFieldName();
                String value = item.getString();
                value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
                //System.out.println(value);
                if(S.equals("BookID")){
                    BookID=value;
                }
                else if(S.equals("Bookname")){
                    Bookname=value;
                }
                else  if(S.equals("author")){
                    author=value;
                }
                else if (S.equals("price")){
                    price=value;
                }
                else if(S.equals("intro")){
                    intro=value;
                }
            }
            else {
                // 根据时间戳创建头像文件
                filename = BookID + ".jpg";
                System.out.println(request.getContextPath());
                /*File f = new File(getServletContext().getRealPath("upload"));*/
                File f = new File("D://image");
                if (!f.exists()) {
                    f.mkdir();
                }
                String imgsrc = f + "/" + filename;
                // 复制文件
                InputStream is = item.getInputStream();
                FileOutputStream fos = new FileOutputStream(imgsrc);
                byte b[] = new byte[1024 * 1024];
                int length = 0;
                while (-1 != (length = is.read(b))) {
                    fos.write(b, 0, length);
                }
                fos.flush();
                fos.close();
            }
        }
        String path="D:\\image\\"+BookID+".jpg";
        System.out.println(BookID+" "+Bookname+" "+author+" "+price+" "+intro);
        Bookcon Bookadd=new Bookcon();
        try {
            Bookadd.insert(BookID,Bookname,author,price,intro,path);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(Bookadd.picture(BookID))
        {
        response.sendRedirect("../BookList.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doPost(request,response);
    }
}
