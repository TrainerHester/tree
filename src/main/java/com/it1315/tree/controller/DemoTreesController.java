package com.it1315.tree.controller;

import com.it1315.tree.entity.Tree;
import com.it1315.tree.entity.User;
import com.it1315.tree.repository.UserRepository;
import com.it1315.tree.service.TreeService;
import com.it1315.tree.service.UserIdGeneratorService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dly on 2018/10/8
 *
 */
@RestController
@RequestMapping("/trees")
public class DemoTreesController {

    @Autowired
    private TreeService treeService;

    @Autowired
    private UserRepository users;

//    @Autowired
//    private DisplayService displayService;

    @Autowired
    private UserIdGeneratorService userIdGenerator;

    public DemoTreesController() throws MalformedURLException {
    }

    public void setUserId(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        boolean flg = false;
        if (cookies.length != 0 ) {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equalsIgnoreCase("userId")){
                    System.out.println(flg);
                    flg = true;
                }
            }
        }
        if (!flg) {
            System.out.println("---------------");
            long userid = userIdGenerator.getUserId();
            response.addCookie(new Cookie("userId", String.valueOf(userid)));
            HashMap<Long, User> userHashMap = new HashMap<>();
            userHashMap.put(userid, new User());
            users.setUsers(userHashMap);
        }
    }


    public List<Tree> getAll(HttpServletRequest request, HttpServletResponse response) {
        return treeService.findTreeWithCondition(new HashMap<>());
    }

    @GetMapping("search/{id}")
    public String getTreeById(@PathVariable(value = "id", required = true) Integer id, HttpServletRequest request, HttpServletResponse response) {
        List<Tree> treeById = treeService.findTreeById(id);
//        if (users.getUser(userId) == null) {
//            long userid = userIdGenerator.getUserId();
//            Cookie[] cookies1 = request.getCookies();
//            for (Cookie cookie:cookies1){
//                if (cookie.getName().equalsIgnoreCase("userId")){
//                    cookie.setMaxAge(-1);
//                }
//            }
//            response.addCookie(new Cookie("userId", String.valueOf(userid)));
//            HashMap<Long, User> userHashMap = new HashMap<>();
//            userHashMap.put(userid, new User());
//            users.setUsers(userHashMap);
//        }
        User user = users.getUser(1l);
        HashMap<String, String> fieldsFilter = user.getFieldsFilter();
        String detailedInfo = fieldsFilter.get("detailedInfo");
        HashMap<String, String> infoTable = new HashMap<>();
        infoTable.put("Id", "<li class='list-group-item'>树木编号 : " + treeById.get(0).getId() + "<a href='/info/"+treeById.get(0).getId()+"'> 详细</a></li>");
        infoTable.put("Lon", "<li class='list-group-item'> 所处经度:"+ treeById.get(0).getLon() + " <a href='http://localhost:63342/table/test-1.html?_ijt=569fbked1bic4s74njum5h2e84#'> 详细</a></li>");
        infoTable.put("Lat", "<li class='list-group-item'>树木纬度 : " + treeById.get(0).getId() + "<a href='http://localhost:63342/table/test-1.html?_ijt=569fbked1bic4s74njum5h2e84#'> 详细</a></li>");
        infoTable.put("Type", "<li class='list-group-item'> 树木种类: "+ treeById.get(0).getTreeType() + "<a href='http://localhost:63342/table/test-1.html?_ijt=569fbked1bic4s74njum5h2e84#'> 详细</a></li>");
        infoTable.put("Height", "<li class='list-group-item'> 树木高度："+ treeById.get(0).getHight() +" <a href='/info/Hight'> 详细</a></li>");
        infoTable.put("Crown", " <li class='list-group-item'> 树木冠幅："+ treeById.get(0).getCrown() + "<a href='http://localhost:63342/table/test-1.html?_ijt=569fbked1bic4s74njum5h2e84#'> 详细</a></li>");
        infoTable.put("Age", " <li class='list-group-item'> 树龄： "+ treeById.get(0).getAge() +" <a href='http://localhost:63342/table/test-1.html?_ijt=569fbked1bic4s74njum5h2e84#'> 详细</a></li>");
        infoTable.put("pic", "<li class='list-group-item'>photoPath : <img src='/imgs/tree.jpg'></li>");


        String preffix = "<url class='list-group'>";
        String suffix = "</url>";
        String[] arr = detailedInfo.split(",");
        String s = preffix;
        for (String str:arr) {
            s += infoTable.get(str);
        }
        s+=suffix;
        return s;
//        return "<url class='list-group'><url></url><li class='list-group-item'>树木编号 : " + treeById.get(0).getId() + "</li><li class='list-group-item'> 所处经度:"+ treeById.get(0).getLon() +" </li><li class='list-group-item'>所处纬度:"+ treeById.get(0).getLat() +" </li><li class='list-group-item'> 树木种类: "+ treeById.get(0).getTreeType() +" </li><li class='list-group-item'> 树木高度："+ treeById.get(0).getHight() +" </li><li class='list-group-item'> 树木冠幅："+ treeById.get(0).getCrown() +" </li><li class='list-group-item'> 树龄： "+ treeById.get(0).getAge() +" </li><li class='list-group-item'>photoPath : <img src='/imgs/tree.jpg'></li><li class='list-group-item'>详细信息 請前往：<a href='/info'> 点击跳转如详细信息页面</a> </li></url>";
//        return "{ detailedInfo:" + detailedInfo + ",info:[" +"Id:树木编号:" + treeById.get(0).getId() + ",Lon:所处经度:"+ treeById.get(0).getLon() +", Lat:所处纬度:"+ treeById.get(0).getLat() +",type:树木种类:"+ treeById.get(0).getTreeType() +",Hight:树木高度:"+ treeById.get(0).getHight() +",Crown:树木冠幅:"+ treeById.get(0).getCrown() +",Age:树龄： "+ treeById.get(0).getAge() +",photoPath : <img src='/imgs/tree.jpg'> ]}";

    }

    @GetMapping("search/{id}/")
    public String getTreeByParam(@PathVariable(value = "id", required = true) Integer id, @Param("detailedFilter") String detailedFilter) {
        List<Tree> treeById = treeService.findTreeById(id);
//        if (users.getUser(userId) == null) {
//            long userid = userIdGenerator.getUserId();
//            Cookie[] cookies1 = request.getCookies();
//            for (Cookie cookie:cookies1){
//                if (cookie.getName().equalsIgnoreCase("userId")){
//                    cookie.setMaxAge(-1);
//                }
//            }
//            response.addCookie(new Cookie("userId", String.valueOf(userid)));
//            HashMap<Long, User> userHashMap = new HashMap<>();
//            userHashMap.put(userid, new User());
//            users.setUsers(userHashMap);
//        }
        User user = users.getUser(1l);
        HashMap<String, String> fieldsFilter = user.getFieldsFilter();
        String detailedInfo = fieldsFilter.get("detailedInfo");
        HashMap<String, String> infoTable = new HashMap<>();
        infoTable.put("Id", "<li class='list-group-item'>树木编号 : " + treeById.get(0).getId() + "<a href='/info/"+treeById.get(0).getId()+"'> 详细</a></li>");
        infoTable.put("Lon", "<li class='list-group-item'> 所处经度:"+ treeById.get(0).getLon() + " <a href='http://localhost:63342/table/test-1.html?_ijt=569fbked1bic4s74njum5h2e84#'> 详细</a></li>");
        infoTable.put("Lat", "<li class='list-group-item'>树木纬度 : " + treeById.get(0).getId() + "<a href='http://localhost:63342/table/test-1.html?_ijt=569fbked1bic4s74njum5h2e84#'> 详细</a></li>");
        infoTable.put("Type", "<li class='list-group-item'> 树木种类: "+ treeById.get(0).getTreeType() + "<a href='http://localhost:63342/table/test-1.html?_ijt=569fbked1bic4s74njum5h2e84#'> 详细</a></li>");
        infoTable.put("Height", "<li class='list-group-item'> 树木高度："+ treeById.get(0).getHight() +" <a href='/info/Hight'> 详细</a></li>");
        infoTable.put("Crown", " <li class='list-group-item'> 树木冠幅："+ treeById.get(0).getCrown() + "<a href='http://localhost:63342/table/test-1.html?_ijt=569fbked1bic4s74njum5h2e84#'> 详细</a></li>");
        infoTable.put("Age", " <li class='list-group-item'> 树龄： "+ treeById.get(0).getAge() +" <a href='http://localhost:63342/table/test-1.html?_ijt=569fbked1bic4s74njum5h2e84#'> 详细</a></li>");
        infoTable.put("pic", "<li class='list-group-item'>photoPath : <img src='/imgs/tree.jpg'></li>");


        String preffix = "<url class='list-group'>";
        String suffix = "</url>";
        String[] arr = detailedInfo.split(",");
        String s = preffix;
        for (String str:arr) {
            s += infoTable.get(str);
        }
        s+=suffix;
        return s;
//        return "<url class='list-group'><url></url><li class='list-group-item'>树木编号 : " + treeById.get(0).getId() + "</li><li class='list-group-item'> 所处经度:"+ treeById.get(0).getLon() +" </li><li class='list-group-item'>所处纬度:"+ treeById.get(0).getLat() +" </li><li class='list-group-item'> 树木种类: "+ treeById.get(0).getTreeType() +" </li><li class='list-group-item'> 树木高度："+ treeById.get(0).getHight() +" </li><li class='list-group-item'> 树木冠幅："+ treeById.get(0).getCrown() +" </li><li class='list-group-item'> 树龄： "+ treeById.get(0).getAge() +" </li><li class='list-group-item'>photoPath : <img src='/imgs/tree.jpg'></li><li class='list-group-item'>详细信息 請前往：<a href='/info'> 点击跳转如详细信息页面</a> </li></url>";
//        return "{ detailedInfo:" + detailedInfo + ",info:[" +"Id:树木编号:" + treeById.get(0).getId() + ",Lon:所处经度:"+ treeById.get(0).getLon() +", Lat:所处纬度:"+ treeById.get(0).getLat() +",type:树木种类:"+ treeById.get(0).getTreeType() +",Hight:树木高度:"+ treeById.get(0).getHight() +",Crown:树木冠幅:"+ treeById.get(0).getCrown() +",Age:树龄： "+ treeById.get(0).getAge() +",photoPath : <img src='/imgs/tree.jpg'> ]}";

    }


    @RequestMapping(value = "search")
    public List<Tree> getCustomedAll(
            @RequestParam(required = false, name = "id") Integer id,
            @RequestParam(required = false, name = "minAge") Integer minAge, @RequestParam(required = false, name = "maxAge") Integer maxAge,
            @RequestParam(required = false, name = "minHight") Double minHight, @RequestParam(required = false, name = "maxHight") Double maxHight,
            @RequestParam(required = false, name = "treeType") List<String> typeList,
            HttpServletRequest request, HttpServletResponse response
    )

    {
//        setUserId(request,response);
        HashMap<String, Object> parMap = new HashMap<>();
        if (null != id) {
            parMap.put("id", id);
            return treeService.findTreeById(id);
        }
        parMap.put("minAge", minAge);
        parMap.put("maxAge", maxAge);
        parMap.put("treeTypes", typeList);
        return treeService.findTreeWithCondition(parMap);
    }


//
//@GetMapping("localhost:8082/{uid}/his-details/charts/{no}")
//public String getChartByNum(@PathVariable("uid") long uid, @PathVariable("no") int num) {
//    return displayService.getChart(uid, num);
//}


//
//@GetMapping("localhost:8082/{uid}/his-details/charts/{no}")
//public String getChartByNum(@PathVariable("uid") long uid, @PathVariable("no") String num) {
//    return displayService.getChart(uid, num);
//}
//
//
//    static URL url = new URL();
//    static URLConnection connection = new HttpURLConnection(url) {
//        @Override
//        public void disconnect() {
//
//        }
//
//        @Override
//        public boolean usingProxy() {
//            return false;
//        }
//
//        @Override
//        public void connect() throws IOException {
//
//        }
//    };
//    static  URLConnection connection1 = new HttpsURLConnection(url) {
//        @Override
//        public void connect() throws IOException {
//
//        }
//
//        @Override
//        public void disconnect() {
//
//        }
//
//        @Override
//        public boolean usingProxy() {
//            return false;
//        }
//
//        @Override
//        public String getCipherSuite() {
//            return null;
//        }
//
//        @Override
//        public Certificate[] getLocalCertificates() {
//            return new Certificate[0];
//        }
//
//        @Override
//        public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
//            return new Certificate[0];
//        }
//    };
//    public static void main(String[] args) {
//        System.out.println(connection1 instanceof HttpsURLConnection);
//    }


//    public List<Tree> getAll() {
//        return treeService.findTreeWithCondition(new HashMap<>());
//    }


}
