package com.dq.photomanagement.bean;

import java.util.ArrayList;
import java.util.List;

public class PhotoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PhotoExample() {
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

        public Criteria andPhotoidIsNull() {
            addCriterion("photoid is null");
            return (Criteria) this;
        }

        public Criteria andPhotoidIsNotNull() {
            addCriterion("photoid is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoidEqualTo(String value) {
            addCriterion("photoid =", value, "photoid");
            return (Criteria) this;
        }

        public Criteria andPhotoidNotEqualTo(String value) {
            addCriterion("photoid <>", value, "photoid");
            return (Criteria) this;
        }

        public Criteria andPhotoidGreaterThan(String value) {
            addCriterion("photoid >", value, "photoid");
            return (Criteria) this;
        }

        public Criteria andPhotoidGreaterThanOrEqualTo(String value) {
            addCriterion("photoid >=", value, "photoid");
            return (Criteria) this;
        }

        public Criteria andPhotoidLessThan(String value) {
            addCriterion("photoid <", value, "photoid");
            return (Criteria) this;
        }

        public Criteria andPhotoidLessThanOrEqualTo(String value) {
            addCriterion("photoid <=", value, "photoid");
            return (Criteria) this;
        }

        public Criteria andPhotoidLike(String value) {
            addCriterion("photoid like", value, "photoid");
            return (Criteria) this;
        }

        public Criteria andPhotoidNotLike(String value) {
            addCriterion("photoid not like", value, "photoid");
            return (Criteria) this;
        }

        public Criteria andPhotoidIn(List<String> values) {
            addCriterion("photoid in", values, "photoid");
            return (Criteria) this;
        }

        public Criteria andPhotoidNotIn(List<String> values) {
            addCriterion("photoid not in", values, "photoid");
            return (Criteria) this;
        }

        public Criteria andPhotoidBetween(String value1, String value2) {
            addCriterion("photoid between", value1, value2, "photoid");
            return (Criteria) this;
        }

        public Criteria andPhotoidNotBetween(String value1, String value2) {
            addCriterion("photoid not between", value1, value2, "photoid");
            return (Criteria) this;
        }

        public Criteria andPhotonameIsNull() {
            addCriterion("photoname is null");
            return (Criteria) this;
        }

        public Criteria andPhotonameIsNotNull() {
            addCriterion("photoname is not null");
            return (Criteria) this;
        }

        public Criteria andPhotonameEqualTo(String value) {
            addCriterion("photoname =", value, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameNotEqualTo(String value) {
            addCriterion("photoname <>", value, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameGreaterThan(String value) {
            addCriterion("photoname >", value, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameGreaterThanOrEqualTo(String value) {
            addCriterion("photoname >=", value, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameLessThan(String value) {
            addCriterion("photoname <", value, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameLessThanOrEqualTo(String value) {
            addCriterion("photoname <=", value, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameLike(String value) {
            addCriterion("photoname like", value, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameNotLike(String value) {
            addCriterion("photoname not like", value, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameIn(List<String> values) {
            addCriterion("photoname in", values, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameNotIn(List<String> values) {
            addCriterion("photoname not in", values, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameBetween(String value1, String value2) {
            addCriterion("photoname between", value1, value2, "photoname");
            return (Criteria) this;
        }

        public Criteria andPhotonameNotBetween(String value1, String value2) {
            addCriterion("photoname not between", value1, value2, "photoname");
            return (Criteria) this;
        }

        public Criteria andGnameIsNull() {
            addCriterion("gname is null");
            return (Criteria) this;
        }

        public Criteria andGnameIsNotNull() {
            addCriterion("gname is not null");
            return (Criteria) this;
        }

        public Criteria andGnameEqualTo(String value) {
            addCriterion("gname =", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotEqualTo(String value) {
            addCriterion("gname <>", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThan(String value) {
            addCriterion("gname >", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThanOrEqualTo(String value) {
            addCriterion("gname >=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThan(String value) {
            addCriterion("gname <", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThanOrEqualTo(String value) {
            addCriterion("gname <=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLike(String value) {
            addCriterion("gname like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotLike(String value) {
            addCriterion("gname not like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameIn(List<String> values) {
            addCriterion("gname in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotIn(List<String> values) {
            addCriterion("gname not in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameBetween(String value1, String value2) {
            addCriterion("gname between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotBetween(String value1, String value2) {
            addCriterion("gname not between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andRealpathIsNull() {
            addCriterion("realpath is null");
            return (Criteria) this;
        }

        public Criteria andRealpathIsNotNull() {
            addCriterion("realpath is not null");
            return (Criteria) this;
        }

        public Criteria andRealpathEqualTo(String value) {
            addCriterion("realpath =", value, "realpath");
            return (Criteria) this;
        }

        public Criteria andRealpathNotEqualTo(String value) {
            addCriterion("realpath <>", value, "realpath");
            return (Criteria) this;
        }

        public Criteria andRealpathGreaterThan(String value) {
            addCriterion("realpath >", value, "realpath");
            return (Criteria) this;
        }

        public Criteria andRealpathGreaterThanOrEqualTo(String value) {
            addCriterion("realpath >=", value, "realpath");
            return (Criteria) this;
        }

        public Criteria andRealpathLessThan(String value) {
            addCriterion("realpath <", value, "realpath");
            return (Criteria) this;
        }

        public Criteria andRealpathLessThanOrEqualTo(String value) {
            addCriterion("realpath <=", value, "realpath");
            return (Criteria) this;
        }

        public Criteria andRealpathLike(String value) {
            addCriterion("realpath like", value, "realpath");
            return (Criteria) this;
        }

        public Criteria andRealpathNotLike(String value) {
            addCriterion("realpath not like", value, "realpath");
            return (Criteria) this;
        }

        public Criteria andRealpathIn(List<String> values) {
            addCriterion("realpath in", values, "realpath");
            return (Criteria) this;
        }

        public Criteria andRealpathNotIn(List<String> values) {
            addCriterion("realpath not in", values, "realpath");
            return (Criteria) this;
        }

        public Criteria andRealpathBetween(String value1, String value2) {
            addCriterion("realpath between", value1, value2, "realpath");
            return (Criteria) this;
        }

        public Criteria andRealpathNotBetween(String value1, String value2) {
            addCriterion("realpath not between", value1, value2, "realpath");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("path is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("path is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("path =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("path <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("path >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("path >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("path <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("path <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("path like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("path not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("path in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("path not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("path between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("path not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(Integer value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(Integer value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(Integer value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(Integer value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(Integer value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<Integer> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<Integer> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(Integer value1, Integer value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
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