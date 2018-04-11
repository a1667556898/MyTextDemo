package com.taochong.joshuachang.mytextdemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * 常守达  2016/12/23 17:04
 * joshuachang0823@gmail.com
 */

public class DBManager {
    private final static  String dbName="text_db";
    private static DBManager mInstance;
    private DaoMaster.DevOpenHelper openHelper;
    private Context context;
    public DBManager(Context context){
        this.context=context;
        openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
    }
    /**
     * 获取单例引用
     */
    public static DBManager getmInstance(Context Context){
        if (mInstance==null){
            synchronized (DBManager.class){
                if (mInstance==null){
                    mInstance=new DBManager(Context);
                }
            }
        }
        return mInstance;
    }
/**
 * 获取可读数据库
 */
    private SQLiteDatabase getReadableDatabase(){
        if (openHelper==null){
            openHelper=new DaoMaster.DevOpenHelper(context,dbName,null);
        }
        SQLiteDatabase db=openHelper.getReadableDatabase();
        return db;
    }
    /**
     * 获取可写数据库
     */
    private SQLiteDatabase getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }
    /**
     * 插入一条记录
     */
    public void insertUser(User user){
        DaoMaster daoMaster=new DaoMaster(getWritableDatabase());
        DaoSession daoSession=daoMaster.newSession();
        UserDao userDao=daoSession.getUserDao();
        userDao.insert(user);
    }

    public void insertBean(Bean bean){
        DaoMaster daoMaster=new DaoMaster(getWritableDatabase());
        DaoSession daoSession=daoMaster.newSession();
        BeanDao userDao=daoSession.getBeanDao();
        userDao.insert(bean);
    }
    /**
     * 插入用户集合
     */
    public void insertUserList(List<User> users){
        if (users==null||users.isEmpty()){
            return;
        }
        DaoMaster daoMaster=new DaoMaster(getWritableDatabase());
        DaoSession daoSession=daoMaster.newSession();
        UserDao userDao=daoSession.getUserDao();
        userDao.insertInTx(users);
    }
    public void insertBeanList(List<Bean> been){
        if (been==null||been.isEmpty()){
            return;
        }
        DaoMaster daoMaster=new DaoMaster(getWritableDatabase());
        DaoSession daoSession=daoMaster.newSession();
        BeanDao userDao=daoSession.getBeanDao();
        userDao.insertInTx(been);
    }
    /**
     * 删除一条记录
     */
    public void deleteUser(User user){
        DaoMaster daoMaster=new DaoMaster(getWritableDatabase());
        DaoSession daoSession=daoMaster.newSession();
        UserDao userDao=daoSession.getUserDao();
        userDao.delete(user);
    }
    public void deleteUser(Bean user){
        DaoMaster daoMaster=new DaoMaster(getWritableDatabase());
        DaoSession daoSession=daoMaster.newSession();
        BeanDao userDao=daoSession.getBeanDao();
        userDao.delete(user);
    }
    /**
     * 更新数据库
     */
    public void updateUser(User user){
        DaoMaster daoMaster=new DaoMaster(getWritableDatabase());
        DaoSession daoSession=daoMaster.newSession();
        UserDao userDao=daoSession.getUserDao();
        userDao.update(user);
    }
    public void updateUser(Bean user){
        DaoMaster daoMaster=new DaoMaster(getWritableDatabase());
        DaoSession daoSession=daoMaster.newSession();
        BeanDao userDao=daoSession.getBeanDao();
        userDao.update(user);
    }
    /**
     * 查询用户列表
     */
    public List<User> queryUserList(){
        DaoMaster daoMaster=new DaoMaster(getReadableDatabase());
        DaoSession daoSession=daoMaster.newSession();
        UserDao userDao=daoSession.getUserDao();
        QueryBuilder<User> qb=userDao.queryBuilder();
        List<User> list=qb.list();
        return list;
    }
    public List<Bean> queryBeanList(){
        DaoMaster daoMaster=new DaoMaster(getReadableDatabase());
        DaoSession daoSession=daoMaster.newSession();
        BeanDao userDao=daoSession.getBeanDao();
        QueryBuilder<Bean> qb=userDao.queryBuilder();
        List<Bean> list=qb.list();
        return list;
    }
    /**
     * 查询用户列表
     */
    public List<User> queryUserList(int age){
        DaoMaster daoMaster=new DaoMaster(getReadableDatabase());
        DaoSession daoSession=daoMaster.newSession();
        UserDao userDao=daoSession.getUserDao();
        QueryBuilder<User> qb=userDao.queryBuilder();
        qb.where(UserDao.Properties.Age.gt(age)).orderAsc(UserDao.Properties.Age);
        List<User> list=qb.list();
        return list;
    }
    public List<Bean> queryBeanList(int age){
        DaoMaster daoMaster=new DaoMaster(getReadableDatabase());
        DaoSession daoSession=daoMaster.newSession();
        BeanDao userDao=daoSession.getBeanDao();
        QueryBuilder<Bean> qb=userDao.queryBuilder();
        qb.where(BeanDao.Properties.Age.gt(age)).orderAsc(BeanDao.Properties.Age);
        List<Bean> list=qb.list();
        return list;
    }
}
