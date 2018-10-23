package org.tsrj.model.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.tsrj.common.page.Page;

public class MemberConditions {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Page page;

    private Date shardDate;

    public MemberConditions() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Page getPage() {
        return this.page;
    }

    public void setShardDate(Date shardDate) {
        this.shardDate = shardDate;
    }

    public Date getShardDate() {
        return this.shardDate;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andTrueNameIsNull() {
            addCriterion("true_name is null");
            return (Criteria) this;
        }

        public Criteria andTrueNameIsNotNull() {
            addCriterion("true_name is not null");
            return (Criteria) this;
        }

        public Criteria andTrueNameEqualTo(String value) {
            addCriterion("true_name =", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameNotEqualTo(String value) {
            addCriterion("true_name <>", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameGreaterThan(String value) {
            addCriterion("true_name >", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameGreaterThanOrEqualTo(String value) {
            addCriterion("true_name >=", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameLessThan(String value) {
            addCriterion("true_name <", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameLessThanOrEqualTo(String value) {
            addCriterion("true_name <=", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameLike(String value) {
            addCriterion("true_name like", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameNotLike(String value) {
            addCriterion("true_name not like", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameIn(List<String> values) {
            addCriterion("true_name in", values, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameNotIn(List<String> values) {
            addCriterion("true_name not in", values, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameBetween(String value1, String value2) {
            addCriterion("true_name between", value1, value2, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameNotBetween(String value1, String value2) {
            addCriterion("true_name not between", value1, value2, "trueName");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberIsNull() {
            addCriterion("identity_number is null");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberIsNotNull() {
            addCriterion("identity_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberEqualTo(String value) {
            addCriterion("identity_number =", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberNotEqualTo(String value) {
            addCriterion("identity_number <>", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberGreaterThan(String value) {
            addCriterion("identity_number >", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberGreaterThanOrEqualTo(String value) {
            addCriterion("identity_number >=", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberLessThan(String value) {
            addCriterion("identity_number <", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberLessThanOrEqualTo(String value) {
            addCriterion("identity_number <=", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberLike(String value) {
            addCriterion("identity_number like", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberNotLike(String value) {
            addCriterion("identity_number not like", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberIn(List<String> values) {
            addCriterion("identity_number in", values, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberNotIn(List<String> values) {
            addCriterion("identity_number not in", values, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberBetween(String value1, String value2) {
            addCriterion("identity_number between", value1, value2, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberNotBetween(String value1, String value2) {
            addCriterion("identity_number not between", value1, value2, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andPayPasswordIsNull() {
            addCriterion("pay_password is null");
            return (Criteria) this;
        }

        public Criteria andPayPasswordIsNotNull() {
            addCriterion("pay_password is not null");
            return (Criteria) this;
        }

        public Criteria andPayPasswordEqualTo(String value) {
            addCriterion("pay_password =", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotEqualTo(String value) {
            addCriterion("pay_password <>", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordGreaterThan(String value) {
            addCriterion("pay_password >", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("pay_password >=", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordLessThan(String value) {
            addCriterion("pay_password <", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordLessThanOrEqualTo(String value) {
            addCriterion("pay_password <=", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordLike(String value) {
            addCriterion("pay_password like", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotLike(String value) {
            addCriterion("pay_password not like", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordIn(List<String> values) {
            addCriterion("pay_password in", values, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotIn(List<String> values) {
            addCriterion("pay_password not in", values, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordBetween(String value1, String value2) {
            addCriterion("pay_password between", value1, value2, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotBetween(String value1, String value2) {
            addCriterion("pay_password not between", value1, value2, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Short value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Short value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Short value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Short value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Short value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Short value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Short> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Short> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Short value1, Short value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Short value1, Short value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andRegisterIpIsNull() {
            addCriterion("register_ip is null");
            return (Criteria) this;
        }

        public Criteria andRegisterIpIsNotNull() {
            addCriterion("register_ip is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterIpEqualTo(String value) {
            addCriterion("register_ip =", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpNotEqualTo(String value) {
            addCriterion("register_ip <>", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpGreaterThan(String value) {
            addCriterion("register_ip >", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpGreaterThanOrEqualTo(String value) {
            addCriterion("register_ip >=", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpLessThan(String value) {
            addCriterion("register_ip <", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpLessThanOrEqualTo(String value) {
            addCriterion("register_ip <=", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpLike(String value) {
            addCriterion("register_ip like", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpNotLike(String value) {
            addCriterion("register_ip not like", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpIn(List<String> values) {
            addCriterion("register_ip in", values, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpNotIn(List<String> values) {
            addCriterion("register_ip not in", values, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpBetween(String value1, String value2) {
            addCriterion("register_ip between", value1, value2, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpNotBetween(String value1, String value2) {
            addCriterion("register_ip not between", value1, value2, "registerIp");
            return (Criteria) this;
        }

        public Criteria andAvatarsIsNull() {
            addCriterion("avatars is null");
            return (Criteria) this;
        }

        public Criteria andAvatarsIsNotNull() {
            addCriterion("avatars is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarsEqualTo(String value) {
            addCriterion("avatars =", value, "avatars");
            return (Criteria) this;
        }

        public Criteria andAvatarsNotEqualTo(String value) {
            addCriterion("avatars <>", value, "avatars");
            return (Criteria) this;
        }

        public Criteria andAvatarsGreaterThan(String value) {
            addCriterion("avatars >", value, "avatars");
            return (Criteria) this;
        }

        public Criteria andAvatarsGreaterThanOrEqualTo(String value) {
            addCriterion("avatars >=", value, "avatars");
            return (Criteria) this;
        }

        public Criteria andAvatarsLessThan(String value) {
            addCriterion("avatars <", value, "avatars");
            return (Criteria) this;
        }

        public Criteria andAvatarsLessThanOrEqualTo(String value) {
            addCriterion("avatars <=", value, "avatars");
            return (Criteria) this;
        }

        public Criteria andAvatarsLike(String value) {
            addCriterion("avatars like", value, "avatars");
            return (Criteria) this;
        }

        public Criteria andAvatarsNotLike(String value) {
            addCriterion("avatars not like", value, "avatars");
            return (Criteria) this;
        }

        public Criteria andAvatarsIn(List<String> values) {
            addCriterion("avatars in", values, "avatars");
            return (Criteria) this;
        }

        public Criteria andAvatarsNotIn(List<String> values) {
            addCriterion("avatars not in", values, "avatars");
            return (Criteria) this;
        }

        public Criteria andAvatarsBetween(String value1, String value2) {
            addCriterion("avatars between", value1, value2, "avatars");
            return (Criteria) this;
        }

        public Criteria andAvatarsNotBetween(String value1, String value2) {
            addCriterion("avatars not between", value1, value2, "avatars");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedIsNull() {
            addCriterion("is_verified is null");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedIsNotNull() {
            addCriterion("is_verified is not null");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedEqualTo(Short value) {
            addCriterion("is_verified =", value, "isVerified");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedNotEqualTo(Short value) {
            addCriterion("is_verified <>", value, "isVerified");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedGreaterThan(Short value) {
            addCriterion("is_verified >", value, "isVerified");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedGreaterThanOrEqualTo(Short value) {
            addCriterion("is_verified >=", value, "isVerified");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedLessThan(Short value) {
            addCriterion("is_verified <", value, "isVerified");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedLessThanOrEqualTo(Short value) {
            addCriterion("is_verified <=", value, "isVerified");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedIn(List<Short> values) {
            addCriterion("is_verified in", values, "isVerified");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedNotIn(List<Short> values) {
            addCriterion("is_verified not in", values, "isVerified");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedBetween(Short value1, Short value2) {
            addCriterion("is_verified between", value1, value2, "isVerified");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedNotBetween(Short value1, Short value2) {
            addCriterion("is_verified not between", value1, value2, "isVerified");
            return (Criteria) this;
        }

        public Criteria andStepPercentIsNull() {
            addCriterion("step_percent is null");
            return (Criteria) this;
        }

        public Criteria andStepPercentIsNotNull() {
            addCriterion("step_percent is not null");
            return (Criteria) this;
        }

        public Criteria andStepPercentEqualTo(Short value) {
            addCriterion("step_percent =", value, "stepPercent");
            return (Criteria) this;
        }

        public Criteria andStepPercentNotEqualTo(Short value) {
            addCriterion("step_percent <>", value, "stepPercent");
            return (Criteria) this;
        }

        public Criteria andStepPercentGreaterThan(Short value) {
            addCriterion("step_percent >", value, "stepPercent");
            return (Criteria) this;
        }

        public Criteria andStepPercentGreaterThanOrEqualTo(Short value) {
            addCriterion("step_percent >=", value, "stepPercent");
            return (Criteria) this;
        }

        public Criteria andStepPercentLessThan(Short value) {
            addCriterion("step_percent <", value, "stepPercent");
            return (Criteria) this;
        }

        public Criteria andStepPercentLessThanOrEqualTo(Short value) {
            addCriterion("step_percent <=", value, "stepPercent");
            return (Criteria) this;
        }

        public Criteria andStepPercentIn(List<Short> values) {
            addCriterion("step_percent in", values, "stepPercent");
            return (Criteria) this;
        }

        public Criteria andStepPercentNotIn(List<Short> values) {
            addCriterion("step_percent not in", values, "stepPercent");
            return (Criteria) this;
        }

        public Criteria andStepPercentBetween(Short value1, Short value2) {
            addCriterion("step_percent between", value1, value2, "stepPercent");
            return (Criteria) this;
        }

        public Criteria andStepPercentNotBetween(Short value1, Short value2) {
            addCriterion("step_percent not between", value1, value2, "stepPercent");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberIsNull() {
            addCriterion("device_serial_number is null");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberIsNotNull() {
            addCriterion("device_serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberEqualTo(String value) {
            addCriterion("device_serial_number =", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberNotEqualTo(String value) {
            addCriterion("device_serial_number <>", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberGreaterThan(String value) {
            addCriterion("device_serial_number >", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("device_serial_number >=", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberLessThan(String value) {
            addCriterion("device_serial_number <", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("device_serial_number <=", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberLike(String value) {
            addCriterion("device_serial_number like", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberNotLike(String value) {
            addCriterion("device_serial_number not like", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberIn(List<String> values) {
            addCriterion("device_serial_number in", values, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberNotIn(List<String> values) {
            addCriterion("device_serial_number not in", values, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberBetween(String value1, String value2) {
            addCriterion("device_serial_number between", value1, value2, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberNotBetween(String value1, String value2) {
            addCriterion("device_serial_number not between", value1, value2, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Short value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Short value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Short value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Short value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Short value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Short> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Short> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Short value1, Short value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Short value1, Short value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andIsHitIsNull() {
            addCriterion("is_hit is null");
            return (Criteria) this;
        }

        public Criteria andIsHitIsNotNull() {
            addCriterion("is_hit is not null");
            return (Criteria) this;
        }

        public Criteria andIsHitEqualTo(Boolean value) {
            addCriterion("is_hit =", value, "isHit");
            return (Criteria) this;
        }

        public Criteria andIsHitNotEqualTo(Boolean value) {
            addCriterion("is_hit <>", value, "isHit");
            return (Criteria) this;
        }

        public Criteria andIsHitGreaterThan(Boolean value) {
            addCriterion("is_hit >", value, "isHit");
            return (Criteria) this;
        }

        public Criteria andIsHitGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_hit >=", value, "isHit");
            return (Criteria) this;
        }

        public Criteria andIsHitLessThan(Boolean value) {
            addCriterion("is_hit <", value, "isHit");
            return (Criteria) this;
        }

        public Criteria andIsHitLessThanOrEqualTo(Boolean value) {
            addCriterion("is_hit <=", value, "isHit");
            return (Criteria) this;
        }

        public Criteria andIsHitIn(List<Boolean> values) {
            addCriterion("is_hit in", values, "isHit");
            return (Criteria) this;
        }

        public Criteria andIsHitNotIn(List<Boolean> values) {
            addCriterion("is_hit not in", values, "isHit");
            return (Criteria) this;
        }

        public Criteria andIsHitBetween(Boolean value1, Boolean value2) {
            addCriterion("is_hit between", value1, value2, "isHit");
            return (Criteria) this;
        }

        public Criteria andIsHitNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_hit not between", value1, value2, "isHit");
            return (Criteria) this;
        }

        public Criteria andUseGesturePasswordIsNull() {
            addCriterion("use_gesture_password is null");
            return (Criteria) this;
        }

        public Criteria andUseGesturePasswordIsNotNull() {
            addCriterion("use_gesture_password is not null");
            return (Criteria) this;
        }

        public Criteria andUseGesturePasswordEqualTo(Boolean value) {
            addCriterion("use_gesture_password =", value, "useGesturePassword");
            return (Criteria) this;
        }

        public Criteria andUseGesturePasswordNotEqualTo(Boolean value) {
            addCriterion("use_gesture_password <>", value, "useGesturePassword");
            return (Criteria) this;
        }

        public Criteria andUseGesturePasswordGreaterThan(Boolean value) {
            addCriterion("use_gesture_password >", value, "useGesturePassword");
            return (Criteria) this;
        }

        public Criteria andUseGesturePasswordGreaterThanOrEqualTo(Boolean value) {
            addCriterion("use_gesture_password >=", value, "useGesturePassword");
            return (Criteria) this;
        }

        public Criteria andUseGesturePasswordLessThan(Boolean value) {
            addCriterion("use_gesture_password <", value, "useGesturePassword");
            return (Criteria) this;
        }

        public Criteria andUseGesturePasswordLessThanOrEqualTo(Boolean value) {
            addCriterion("use_gesture_password <=", value, "useGesturePassword");
            return (Criteria) this;
        }

        public Criteria andUseGesturePasswordIn(List<Boolean> values) {
            addCriterion("use_gesture_password in", values, "useGesturePassword");
            return (Criteria) this;
        }

        public Criteria andUseGesturePasswordNotIn(List<Boolean> values) {
            addCriterion("use_gesture_password not in", values, "useGesturePassword");
            return (Criteria) this;
        }

        public Criteria andUseGesturePasswordBetween(Boolean value1, Boolean value2) {
            addCriterion("use_gesture_password between", value1, value2, "useGesturePassword");
            return (Criteria) this;
        }

        public Criteria andUseGesturePasswordNotBetween(Boolean value1, Boolean value2) {
            addCriterion("use_gesture_password not between", value1, value2, "useGesturePassword");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("channel is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("channel is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(String value) {
            addCriterion("channel =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(String value) {
            addCriterion("channel <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(String value) {
            addCriterion("channel >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(String value) {
            addCriterion("channel >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(String value) {
            addCriterion("channel <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(String value) {
            addCriterion("channel <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLike(String value) {
            addCriterion("channel like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotLike(String value) {
            addCriterion("channel not like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<String> values) {
            addCriterion("channel in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<String> values) {
            addCriterion("channel not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(String value1, String value2) {
            addCriterion("channel between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(String value1, String value2) {
            addCriterion("channel not between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andFadadaCustomerIdIsNull() {
            addCriterion("fadada_customer_id is null");
            return (Criteria) this;
        }

        public Criteria andFadadaCustomerIdIsNotNull() {
            addCriterion("fadada_customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andFadadaCustomerIdEqualTo(String value) {
            addCriterion("fadada_customer_id =", value, "fadadaCustomerId");
            return (Criteria) this;
        }

        public Criteria andFadadaCustomerIdNotEqualTo(String value) {
            addCriterion("fadada_customer_id <>", value, "fadadaCustomerId");
            return (Criteria) this;
        }

        public Criteria andFadadaCustomerIdGreaterThan(String value) {
            addCriterion("fadada_customer_id >", value, "fadadaCustomerId");
            return (Criteria) this;
        }

        public Criteria andFadadaCustomerIdGreaterThanOrEqualTo(String value) {
            addCriterion("fadada_customer_id >=", value, "fadadaCustomerId");
            return (Criteria) this;
        }

        public Criteria andFadadaCustomerIdLessThan(String value) {
            addCriterion("fadada_customer_id <", value, "fadadaCustomerId");
            return (Criteria) this;
        }

        public Criteria andFadadaCustomerIdLessThanOrEqualTo(String value) {
            addCriterion("fadada_customer_id <=", value, "fadadaCustomerId");
            return (Criteria) this;
        }

        public Criteria andFadadaCustomerIdLike(String value) {
            addCriterion("fadada_customer_id like", value, "fadadaCustomerId");
            return (Criteria) this;
        }

        public Criteria andFadadaCustomerIdNotLike(String value) {
            addCriterion("fadada_customer_id not like", value, "fadadaCustomerId");
            return (Criteria) this;
        }

        public Criteria andFadadaCustomerIdIn(List<String> values) {
            addCriterion("fadada_customer_id in", values, "fadadaCustomerId");
            return (Criteria) this;
        }

        public Criteria andFadadaCustomerIdNotIn(List<String> values) {
            addCriterion("fadada_customer_id not in", values, "fadadaCustomerId");
            return (Criteria) this;
        }

        public Criteria andFadadaCustomerIdBetween(String value1, String value2) {
            addCriterion("fadada_customer_id between", value1, value2, "fadadaCustomerId");
            return (Criteria) this;
        }

        public Criteria andFadadaCustomerIdNotBetween(String value1, String value2) {
            addCriterion("fadada_customer_id not between", value1, value2, "fadadaCustomerId");
            return (Criteria) this;
        }

        public Criteria andRepayDayIsNull() {
            addCriterion("repay_day is null");
            return (Criteria) this;
        }

        public Criteria andRepayDayIsNotNull() {
            addCriterion("repay_day is not null");
            return (Criteria) this;
        }

        public Criteria andRepayDayEqualTo(Integer value) {
            addCriterion("repay_day =", value, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayNotEqualTo(Integer value) {
            addCriterion("repay_day <>", value, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayGreaterThan(Integer value) {
            addCriterion("repay_day >", value, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("repay_day >=", value, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayLessThan(Integer value) {
            addCriterion("repay_day <", value, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayLessThanOrEqualTo(Integer value) {
            addCriterion("repay_day <=", value, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayIn(List<Integer> values) {
            addCriterion("repay_day in", values, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayNotIn(List<Integer> values) {
            addCriterion("repay_day not in", values, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayBetween(Integer value1, Integer value2) {
            addCriterion("repay_day between", value1, value2, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayNotBetween(Integer value1, Integer value2) {
            addCriterion("repay_day not between", value1, value2, "repayDay");
            return (Criteria) this;
        }

        public Criteria andIsBaseRealNameIsNull() {
            addCriterion("is_base_real_name is null");
            return (Criteria) this;
        }

        public Criteria andIsBaseRealNameIsNotNull() {
            addCriterion("is_base_real_name is not null");
            return (Criteria) this;
        }

        public Criteria andIsBaseRealNameEqualTo(Integer value) {
            addCriterion("is_base_real_name =", value, "isBaseRealName");
            return (Criteria) this;
        }

        public Criteria andIsBaseRealNameNotEqualTo(Integer value) {
            addCriterion("is_base_real_name <>", value, "isBaseRealName");
            return (Criteria) this;
        }

        public Criteria andIsBaseRealNameGreaterThan(Integer value) {
            addCriterion("is_base_real_name >", value, "isBaseRealName");
            return (Criteria) this;
        }

        public Criteria andIsBaseRealNameGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_base_real_name >=", value, "isBaseRealName");
            return (Criteria) this;
        }

        public Criteria andIsBaseRealNameLessThan(Integer value) {
            addCriterion("is_base_real_name <", value, "isBaseRealName");
            return (Criteria) this;
        }

        public Criteria andIsBaseRealNameLessThanOrEqualTo(Integer value) {
            addCriterion("is_base_real_name <=", value, "isBaseRealName");
            return (Criteria) this;
        }

        public Criteria andIsBaseRealNameIn(List<Integer> values) {
            addCriterion("is_base_real_name in", values, "isBaseRealName");
            return (Criteria) this;
        }

        public Criteria andIsBaseRealNameNotIn(List<Integer> values) {
            addCriterion("is_base_real_name not in", values, "isBaseRealName");
            return (Criteria) this;
        }

        public Criteria andIsBaseRealNameBetween(Integer value1, Integer value2) {
            addCriterion("is_base_real_name between", value1, value2, "isBaseRealName");
            return (Criteria) this;
        }

        public Criteria andIsBaseRealNameNotBetween(Integer value1, Integer value2) {
            addCriterion("is_base_real_name not between", value1, value2, "isBaseRealName");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andRealNameTimeIsNull() {
            addCriterion("real_name_time is null");
            return (Criteria) this;
        }

        public Criteria andRealNameTimeIsNotNull() {
            addCriterion("real_name_time is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameTimeEqualTo(Date value) {
            addCriterion("real_name_time =", value, "realNameTime");
            return (Criteria) this;
        }

        public Criteria andRealNameTimeNotEqualTo(Date value) {
            addCriterion("real_name_time <>", value, "realNameTime");
            return (Criteria) this;
        }

        public Criteria andRealNameTimeGreaterThan(Date value) {
            addCriterion("real_name_time >", value, "realNameTime");
            return (Criteria) this;
        }

        public Criteria andRealNameTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("real_name_time >=", value, "realNameTime");
            return (Criteria) this;
        }

        public Criteria andRealNameTimeLessThan(Date value) {
            addCriterion("real_name_time <", value, "realNameTime");
            return (Criteria) this;
        }

        public Criteria andRealNameTimeLessThanOrEqualTo(Date value) {
            addCriterion("real_name_time <=", value, "realNameTime");
            return (Criteria) this;
        }

        public Criteria andRealNameTimeIn(List<Date> values) {
            addCriterion("real_name_time in", values, "realNameTime");
            return (Criteria) this;
        }

        public Criteria andRealNameTimeNotIn(List<Date> values) {
            addCriterion("real_name_time not in", values, "realNameTime");
            return (Criteria) this;
        }

        public Criteria andRealNameTimeBetween(Date value1, Date value2) {
            addCriterion("real_name_time between", value1, value2, "realNameTime");
            return (Criteria) this;
        }

        public Criteria andRealNameTimeNotBetween(Date value1, Date value2) {
            addCriterion("real_name_time not between", value1, value2, "realNameTime");
            return (Criteria) this;
        }

        public Criteria andBelongToIsNull() {
            addCriterion("belong_to is null");
            return (Criteria) this;
        }

        public Criteria andBelongToIsNotNull() {
            addCriterion("belong_to is not null");
            return (Criteria) this;
        }

        public Criteria andBelongToEqualTo(Integer value) {
            addCriterion("belong_to =", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToNotEqualTo(Integer value) {
            addCriterion("belong_to <>", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToGreaterThan(Integer value) {
            addCriterion("belong_to >", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToGreaterThanOrEqualTo(Integer value) {
            addCriterion("belong_to >=", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToLessThan(Integer value) {
            addCriterion("belong_to <", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToLessThanOrEqualTo(Integer value) {
            addCriterion("belong_to <=", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToIn(List<Integer> values) {
            addCriterion("belong_to in", values, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToNotIn(List<Integer> values) {
            addCriterion("belong_to not in", values, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToBetween(Integer value1, Integer value2) {
            addCriterion("belong_to between", value1, value2, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToNotBetween(Integer value1, Integer value2) {
            addCriterion("belong_to not between", value1, value2, "belongTo");
            return (Criteria) this;
        }

        public Criteria andUserNameLikeInsensitive(String value) {
            addCriterion("upper(user_name) like", value.toUpperCase(), "userName");
            return (Criteria) this;
        }

        public Criteria andTrueNameLikeInsensitive(String value) {
            addCriterion("upper(true_name) like", value.toUpperCase(), "trueName");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberLikeInsensitive(String value) {
            addCriterion("upper(identity_number) like", value.toUpperCase(), "identityNumber");
            return (Criteria) this;
        }

        public Criteria andPayPasswordLikeInsensitive(String value) {
            addCriterion("upper(pay_password) like", value.toUpperCase(), "payPassword");
            return (Criteria) this;
        }

        public Criteria andPasswordLikeInsensitive(String value) {
            addCriterion("upper(password) like", value.toUpperCase(), "password");
            return (Criteria) this;
        }

        public Criteria andMobileLikeInsensitive(String value) {
            addCriterion("upper(mobile) like", value.toUpperCase(), "mobile");
            return (Criteria) this;
        }

        public Criteria andRegisterIpLikeInsensitive(String value) {
            addCriterion("upper(register_ip) like", value.toUpperCase(), "registerIp");
            return (Criteria) this;
        }

        public Criteria andAvatarsLikeInsensitive(String value) {
            addCriterion("upper(avatars) like", value.toUpperCase(), "avatars");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberLikeInsensitive(String value) {
            addCriterion("upper(device_serial_number) like", value.toUpperCase(), "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andChannelLikeInsensitive(String value) {
            addCriterion("upper(channel) like", value.toUpperCase(), "channel");
            return (Criteria) this;
        }

        public Criteria andFadadaCustomerIdLikeInsensitive(String value) {
            addCriterion("upper(fadada_customer_id) like", value.toUpperCase(), "fadadaCustomerId");
            return (Criteria) this;
        }

        public Criteria andNickNameLikeInsensitive(String value) {
            addCriterion("upper(nick_name) like", value.toUpperCase(), "nickName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria addByMap(Map<String, Object> map) {
             for (Map.Entry<String, Object> entry : map.entrySet()) {
                if(entry.getValue().toString().startsWith("%")){
                    addCriterion(entry.getKey()+" like",entry.getValue(),null);
                }else{
                    addCriterion(entry.getKey()+" =",entry.getValue(),null);
                }
            }
            return this;
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}