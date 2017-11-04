package com.fzc.fangzc.entity;

/**
 * UserInfo
 * <p>
 * Created by Administrator on 2017/11/1 0001.
 */
public class UserInfo {
    private int id;    //	用户ID
    private String uid;    //用户UID，通过第三方平台注册时的uid
    private String nickname;    //	昵称
    private String realname;    //	真实姓名
    private String phone;    //	手机号码
    private String password;    //	密码
    private String email;    //	邮箱
    private String avatar;    //	头像
    private int points;  //积分
    private String tags;    //	标签/勋章
    private int coupons;  //优惠券数量
    private String birthday;    //	生日
    private String sex;    //	性别
    private String province;    //	省
    private String city;    //	市
    private String address;    //	地址
    private String qq;    //	QQ昵称
    private String weibo;    //	微博昵称
    private String weixin;    //	微信昵称
    private String idCard;    //	身份证号码
    private String isPwdEmpty;    //	密码是否为空。密码为空的用户，不能通过账号密码登录。
    private int role;    //	角色，0为普通用户
    private int status;    //	状态
    private boolean recommendOthers;    //是否可以推荐他人
    private boolean enterpriseCertification;    //是否企业认证
    private String inviteCode;    //邀请码
    private int inviteCount;    //邀请人数
    private int inviterId; //	邀请人ID

    public UserInfo() {
    }

    public UserInfo(UserInfo info) {
        this.id = info.getId();
        this.nickname = info.getNickname();
        this.realname = info.getRealname();
        this.phone = info.getPhone();
        this.email = info.getEmail();
        this.avatar = info.getAvatar();
        this.points = info.getPoints();
        this.tags = info.getTags();
        this.sex = info.getSex();
        this.province = info.getProvince();
        this.city = info.getCity();
        this.address = info.getAddress();
    }

    public UserInfo(int id, String nickname, String realname, String phone, String email, String avatar, int points, String tags, String sex, String province, String city, String address) {
        this.id = id;
        this.nickname = nickname;
        this.realname = realname;
        this.phone = phone;
        this.email = email;
        this.avatar = avatar;
        this.points = points;
        this.tags = tags;
        this.sex = sex;
        this.province = province;
        this.city = city;
        this.address = address;
    }

    public UserInfo(int id, String nickname, String realname, String phone, String password, String email, String avatar, int points, String tags, String sex, String province, String city, String address) {
        this.id = id;
        this.nickname = nickname;
        this.realname = realname;
        this.phone = phone;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.points = points;
        this.tags = tags;
        this.sex = sex;
        this.province = province;
        this.city = city;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getCoupons() {
        return coupons;
    }

    public void setCoupons(int coupons) {
        this.coupons = coupons;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIsPwdEmpty() {
        return isPwdEmpty;
    }

    public void setIsPwdEmpty(String isPwdEmpty) {
        this.isPwdEmpty = isPwdEmpty;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isRecommendOthers() {
        return recommendOthers;
    }

    public void setRecommendOthers(boolean recommendOthers) {
        this.recommendOthers = recommendOthers;
    }

    public boolean isEnterpriseCertification() {
        return enterpriseCertification;
    }

    public void setEnterpriseCertification(boolean enterpriseCertification) {
        this.enterpriseCertification = enterpriseCertification;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public int getInviteCount() {
        return inviteCount;
    }

    public void setInviteCount(int inviteCount) {
        this.inviteCount = inviteCount;
    }

    public int getInviterId() {
        return inviterId;
    }

    public void setInviterId(int inviterId) {
        this.inviterId = inviterId;
    }
}
