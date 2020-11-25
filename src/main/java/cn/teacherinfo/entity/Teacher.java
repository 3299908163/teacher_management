package cn.teacherinfo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 教师表
 */
public class Teacher {
//    @TableId(type = IdType.AUTO)
    private Integer userId;

    private String userName;

    private String userSex;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date userBirthday;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date userWorkhours;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date userJoinparty;

    private String userIdentity;

    private String userAddress;

    private String userEmail;

    private String userPhone;

    private Integer titleId;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date titleTime;

    private Integer positionId;

    private Integer qualificationId;

    private Integer subjectId;

    private Integer contractId;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date contractStarttime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date contractEndtime;

    private String educationFirstName;

    private String educationFirstSchool;

    private String educationFirstProfessionalName;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date educationFirstGraduationtime;

    private Integer degreeId;

    private String educationHighestName;

    private String educationHighestSchool;

    private String educationHighestProfessionalName;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date educationHighestGraduationtime;

    private String remarks;

    private String sessionId;

    private String isAdmin;

    /**
     * 联系其他表的属性,@TableField(exist = false)表示该值不是当前表的字段，但项目必须用到，Mybatis-plus会忽略掉
     */

    @TableField(exist = false)
    private Title title;

    @TableField(exist = false)
    private Subject subject;

    @TableField(exist = false)
    private Qualification qualification;

    @TableField(exist = false)
    private Position position;

    @TableField(exist = false)
    private Degree degree;

    @TableField(exist = false)
    private Contract contract;

    public Teacher() {
    }

    public Teacher(Integer userId, String userName, String userSex, Date userBirthday, Date userWorkhours, Date userJoinparty, String userIdentity, String userAddress, String userEmail, String userPhone, Integer titleId, Date titleTime, Integer positionId, Integer qualificationId, Integer subjectId, Integer contractId, Date contractStarttime, Date contractEndtime, String educationFirstName, String educationFirstSchool, String educationFirstProfessionalName, Date educationFirstGraduationtime, Integer degreeId, String educationHighestName, String educationHighestSchool, String educationHighestProfessionalName, Date educationHighestGraduationtime, String remarks, String sessionId, String isAdmin, Title title, Subject subject, Qualification qualification, Position position, Degree degree, Contract contract) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userBirthday = userBirthday;
        this.userWorkhours = userWorkhours;
        this.userJoinparty = userJoinparty;
        this.userIdentity = userIdentity;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.titleId = titleId;
        this.titleTime = titleTime;
        this.positionId = positionId;
        this.qualificationId = qualificationId;
        this.subjectId = subjectId;
        this.contractId = contractId;
        this.contractStarttime = contractStarttime;
        this.contractEndtime = contractEndtime;
        this.educationFirstName = educationFirstName;
        this.educationFirstSchool = educationFirstSchool;
        this.educationFirstProfessionalName = educationFirstProfessionalName;
        this.educationFirstGraduationtime = educationFirstGraduationtime;
        this.degreeId = degreeId;
        this.educationHighestName = educationHighestName;
        this.educationHighestSchool = educationHighestSchool;
        this.educationHighestProfessionalName = educationHighestProfessionalName;
        this.educationHighestGraduationtime = educationHighestGraduationtime;
        this.remarks = remarks;
        this.sessionId = sessionId;
        this.isAdmin = isAdmin;
        this.title = title;
        this.subject = subject;
        this.qualification = qualification;
        this.position = position;
        this.degree = degree;
        this.contract = contract;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Date getUserWorkhours() {
        return userWorkhours;
    }

    public void setUserWorkhours(Date userWorkhours) {
        this.userWorkhours = userWorkhours;
    }

    public Date getUserJoinparty() {
        return userJoinparty;
    }

    public void setUserJoinparty(Date userJoinparty) {
        this.userJoinparty = userJoinparty;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public Date getTitleTime() {
        return titleTime;
    }

    public void setTitleTime(Date titleTime) {
        this.titleTime = titleTime;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(Integer qualificationId) {
        this.qualificationId = qualificationId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Date getContractStarttime() {
        return contractStarttime;
    }

    public void setContractStarttime(Date contractStarttime) {
        this.contractStarttime = contractStarttime;
    }

    public Date getContractEndtime() {
        return contractEndtime;
    }

    public void setContractEndtime(Date contractEndtime) {
        this.contractEndtime = contractEndtime;
    }

    public String getEducationFirstName() {
        return educationFirstName;
    }

    public void setEducationFirstName(String educationFirstName) {
        this.educationFirstName = educationFirstName;
    }

    public String getEducationFirstSchool() {
        return educationFirstSchool;
    }

    public void setEducationFirstSchool(String educationFirstSchool) {
        this.educationFirstSchool = educationFirstSchool;
    }

    public String getEducationFirstProfessionalName() {
        return educationFirstProfessionalName;
    }

    public void setEducationFirstProfessionalName(String educationFirstProfessionalName) {
        this.educationFirstProfessionalName = educationFirstProfessionalName;
    }

    public Date getEducationFirstGraduationtime() {
        return educationFirstGraduationtime;
    }

    public void setEducationFirstGraduationtime(Date educationFirstGraduationtime) {
        this.educationFirstGraduationtime = educationFirstGraduationtime;
    }

    public Integer getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Integer degreeId) {
        this.degreeId = degreeId;
    }

    public String getEducationHighestName() {
        return educationHighestName;
    }

    public void setEducationHighestName(String educationHighestName) {
        this.educationHighestName = educationHighestName;
    }

    public String getEducationHighestSchool() {
        return educationHighestSchool;
    }

    public void setEducationHighestSchool(String educationHighestSchool) {
        this.educationHighestSchool = educationHighestSchool;
    }

    public String getEducationHighestProfessionalName() {
        return educationHighestProfessionalName;
    }

    public void setEducationHighestProfessionalName(String educationHighestProfessionalName) {
        this.educationHighestProfessionalName = educationHighestProfessionalName;
    }

    public Date getEducationHighestGraduationtime() {
        return educationHighestGraduationtime;
    }

    public void setEducationHighestGraduationtime(Date educationHighestGraduationtime) {
        this.educationHighestGraduationtime = educationHighestGraduationtime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
