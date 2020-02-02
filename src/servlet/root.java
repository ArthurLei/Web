//package servlet;
//// Author: Arthur
//// date: 2019/12/15  10:38
//
//import dao.Bookcon;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//public class root {
//    public static void insertbook() throws SQLException {
//        Bookcon Book=new Bookcon();
//
//
////        String bookid="A00002";
////        String bookname="房思琪的初恋乐园";
////        String price="43";
////        String intro="令人心碎却无能为力的真实故事。\n" +
////                "\n" +
////                "向死而生的文学绝唱 打动万千读者的年度华语小说。\n" +
////                "\n" +
////                "李银河 戴锦华 骆以军 张悦然 冯唐 詹宏志 蒋方舟 史航 等多位学者作家社会名人郑重推荐。";
////        String path = "D:\\IntelliJ IDEA 2019.1.3\\IdeaProjects\\Web\\src\\resources\\0.jpg";
//
//
//
//
////        String bookid="A00003";
////        String bookname="平凡的世界";
////        String author="";
////        String price="60";
////        String intro="这是一部现实主义小说，也是小说化的家族史。作家高度浓缩了中国西北农村的历史变迁过程，作品达到了思想性与艺术性的高度统一，特别是主人公面对困境艰苦奋斗的精神，对今天的大学生朋友仍有启迪。这是一部全景式地表现中国当代城乡社会生活的长篇小说，本书共三部。作者在近十年间广阔背景 上，通过复杂的矛盾纠葛，刻画了社会各阶层众多普通人的形象。劳动与爱情，挫折与追求，痛苦与欢乐，日常生活与巨大社会冲突，纷繁地交织在一起，深刻地展示了普通人在大时代历史进程中所走过的艰难曲折的道路。";
////        String path = "C:\\Users\\13696\\Desktop\\JAVA大作业\\A00003.jpg";
//
//
//
////        String bookid="A00001";
////        String bookname="图解HTTP";
////        String author="日 上野宣  于均良 译";
////        String price="49";
////        String intro="本书对互联网基盘——HTTP协议进行了全面系统的介绍。作者由HTTP协议的发展历史娓娓道来，严谨细致地剖析了HTTP协议的结构，列举诸多常见通信场景及实战案例，最后延伸到Web安全、最新技术动向等方面。本书的特色为在讲解的同时，辅以大量生动形象的通信图例，更好地帮助读者深刻理解HTTP通信过程中客户端与服务器之间的交互情况。读者可通过本书快速了解并掌握HTTP协议的基础，前端工程师分析抓包数据，后端工程师实现REST API、实现自己的HTTP服务器等过程中所需的HTTP相关知识点本书均有介绍。\n" +
////                "\n" +
////                "本书适合Web开发工程师，以及对HTTP协议感兴趣的各层次读者。";
////        String path = "C:\\Users\\13696\\Desktop\\JAVA大作业\\A00001.jpg";
//
//        String bookid="A00004";
//        String bookname="围城";
//        String author="钱钟书";
//        String price="49";
//        String intro="《围城》是钱钟书所著的长篇小说。第一版于1947年由上海晨光出版公司出版。1949年之后，由于政治等方面的原因，本书长期无法在中国大陆和台湾重印，仅在香港出现过盗印本。1980年由作者重新修订之后，在中国大陆地区由人民文学出版社刊印。此后作者又曾小幅修改过几次。《围城》 自从出版以来，就受到许多人的推崇。由于1949年后长期无法重印，这本书逐渐淡出人们的视野。1960年代，旅美汉学家夏志清在《中国现代小说史》(A History of Modern Chinese Fiction)中对本书作出很高的评价，这才重新引起人们对它的关注。人们对它的评价一般集中在两方面，幽默的语言和对生活深刻的观察。从1990年代开始，也有人提出对本书的不同看法，认为这是一部被“拔高”的小说，并不是一部出色的作品。很多人认为这是一部幽默作品。除了各具特色的人物语言之外，作者夹叙其间的文字也显着机智与幽默。这是本书的一大特色。也有人认为这是作者卖弄文字，语言显得尖酸刻薄。但这一说法并不为大多数人接受。";
//        String path = "C:\\Users\\13696\\Desktop\\JAVA大作业\\A00004.jpg";
//
//
//        boolean Flag=Book.insert(bookid,bookname,author,price,intro,path);
//        if (Flag)
//        {
//            System.out.print("插入数据成功！");
//        }
//        else {
//            System.out.print("插入数据失败！");
//        }
//    }
//    static public void main(String args []) throws SQLException {
//        //insertbook();
//        Bookcon b=new Bookcon();
//        b.picture("A00004");
//    }
//}
