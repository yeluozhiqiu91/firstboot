package com.wang.model;

/**
 * 进口保健品
 */
public class ImportHealthyDrug extends BaseModel{
    public String productor_name_en;///    //    生产企业英文名称
    public String unregister_reason;// //            注销原因
    public String addre;// //    地址
    public String health_func;//  //    保健功能	改善睡眠
    public String constitute;//   //    功效成分/标志性成份含量
    public String main_material;//          //            主要原料
    public String unlimite_scope;//        适宜人群
    public String limite_scope;//                      不适宜人群
    public String specification;//            产品规格
    public String expiration_date;//    保质期
    public String reserve_method;//            贮藏方法
    public String lookout;//    注意事项
    public String approval_change_date;//    批准变更日期
    public String changed_content;//            变更内容
    public String record_date;//    备案日期
    public String exchanger_name;//    转让方中文名称
    public String exchanger_name_en;//            转让方英文名称
    public String exchanger_addre;//    转让方地址
    public String taker;//           //      受让方中文名称
    public String taker_addr;//    受让方地址
    public String approval_before;//            转让前批准文号
    public String exchange_date;//    批准转让日期
    public String supplement_date;//            补发日期
    public String extra_hint;//                        备注
    public String product_name_en;//                       产品英文名称
    public String approval_date;//       批准日期	1997-10-29
    public String applicant_chinese_name;//    申请人中文名称	北京珍安荣贸易有限责任公司
    public String product_sn;//       产品编号	-113
    public String approval;//       批准文号	卫进食健字(1997)第053号
    public String product_name;//          产品中文名称	美松宁褪黑素片(原名：美寿宁)
    public String applicant_name;//       申请人英文名称
    public String applicant_addre;//                申请人地址
    public String company_name;//                  生产企业中文名称
    public String produce_county;//                生产国（地区）
    public String use_illustration;//        食用方法及食用量
    public String record_content;//           备案内容
    public String taker_en;//           //    受让方英文名称
    public String validate_date_to;//    //            有效期至
    public String unregister_date;//    注销日期


    public String url;//    页面地址

    @Override
    public String toString() {
        return "ImportHealthyDrug{" +
                "productor_name_en='" + productor_name_en + '\'' +
                ", unregister_reason='" + unregister_reason + '\'' +
                ", addre='" + addre + '\'' +
                ", health_func='" + health_func + '\'' +
                ", constitute='" + constitute + '\'' +
                ", main_material='" + main_material + '\'' +
                ", unlimite_scope='" + unlimite_scope + '\'' +
                ", limite_scope='" + limite_scope + '\'' +
                ", specification='" + specification + '\'' +
                ", expiration_date='" + expiration_date + '\'' +
                ", reserve_method='" + reserve_method + '\'' +
                ", lookout='" + lookout + '\'' +
                ", approval_change_date='" + approval_change_date + '\'' +
                ", changed_content='" + changed_content + '\'' +
                ", record_date='" + record_date + '\'' +
                ", exchanger_name='" + exchanger_name + '\'' +
                ", exchanger_name_en='" + exchanger_name_en + '\'' +
                ", exchanger_addre='" + exchanger_addre + '\'' +
                ", taker='" + taker + '\'' +
                ", taker_addr='" + taker_addr + '\'' +
                ", approval_before='" + approval_before + '\'' +
                ", exchange_date='" + exchange_date + '\'' +
                ", supplement_date='" + supplement_date + '\'' +
                ", extra_hint='" + extra_hint + '\'' +
                ", product_name_en='" + product_name_en + '\'' +
                ", approval_date='" + approval_date + '\'' +
                ", applicant_chinese_name='" + applicant_chinese_name + '\'' +
                ", product_sn='" + product_sn + '\'' +
                ", approval='" + approval + '\'' +
                ", product_name='" + product_name + '\'' +
                ", applicant_name='" + applicant_name + '\'' +
                ", applicant_addre='" + applicant_addre + '\'' +
                ", company_name='" + company_name + '\'' +
                ", produce_county='" + produce_county + '\'' +
                ", use_illustration='" + use_illustration + '\'' +
                ", record_content='" + record_content + '\'' +
                ", taker_en='" + taker_en + '\'' +
                ", validate_date_to='" + validate_date_to + '\'' +
                ", unregister_date='" + unregister_date + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setProductor_name_en(String productor_name_en) {
        this.productor_name_en = productor_name_en;
    }

    public void setUnregister_reason(String unregister_reason) {
        this.unregister_reason = unregister_reason;
    }

    public void setAddre(String addre) {
        this.addre = addre;
    }

    public void setHealth_func(String health_func) {
        this.health_func = health_func;
    }

    public void setConstitute(String constitute) {
        this.constitute = constitute;
    }

    public void setMain_material(String main_material) {
        this.main_material = main_material;
    }

    public void setUnlimite_scope(String unlimite_scope) {
        this.unlimite_scope = unlimite_scope;
    }

    public void setLimite_scope(String limite_scope) {
        this.limite_scope = limite_scope;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public void setReserve_method(String reserve_method) {
        this.reserve_method = reserve_method;
    }

    public void setLookout(String lookout) {
        this.lookout = lookout;
    }

    public void setApproval_change_date(String approval_change_date) {
        this.approval_change_date = approval_change_date;
    }

    public void setChanged_content(String changed_content) {
        this.changed_content = changed_content;
    }

    public void setRecord_date(String record_date) {
        this.record_date = record_date;
    }

    public void setExchanger_name(String exchanger_name) {
        this.exchanger_name = exchanger_name;
    }

    public void setExchanger_name_en(String exchanger_name_en) {
        this.exchanger_name_en = exchanger_name_en;
    }

    public void setExchanger_addre(String exchanger_addre) {
        this.exchanger_addre = exchanger_addre;
    }

    public void setTaker(String taker) {
        this.taker = taker;
    }

    public void setTaker_addr(String taker_addr) {
        this.taker_addr = taker_addr;
    }

    public void setApproval_before(String approval_before) {
        this.approval_before = approval_before;
    }

    public void setExchange_date(String exchange_date) {
        this.exchange_date = exchange_date;
    }

    public void setSupplement_date(String supplement_date) {
        this.supplement_date = supplement_date;
    }

    public void setExtra_hint(String extra_hint) {
        this.extra_hint = extra_hint;
    }

    public void setProduct_name_en(String product_name_en) {
        this.product_name_en = product_name_en;
    }

    public void setApproval_date(String approval_date) {
        this.approval_date = approval_date;
    }

    public void setApplicant_chinese_name(String applicant_chinese_name) {
        this.applicant_chinese_name = applicant_chinese_name;
    }

    public void setProduct_sn(String product_sn) {
        this.product_sn = product_sn;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setApplicant_name(String applicant_name) {
        this.applicant_name = applicant_name;
    }

    public void setApplicant_addre(String applicant_addre) {
        this.applicant_addre = applicant_addre;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void setProduce_county(String produce_county) {
        this.produce_county = produce_county;
    }

    public void setUse_illustration(String use_illustration) {
        this.use_illustration = use_illustration;
    }

    public void setRecord_content(String record_content) {
        this.record_content = record_content;
    }

    public void setTaker_en(String taker_en) {
        this.taker_en = taker_en;
    }

    public void setValidate_date_to(String validate_date_to) {
        this.validate_date_to = validate_date_to;
    }

    public void setUnregister_date(String unregister_date) {
        this.unregister_date = unregister_date;
    }

    public String getProductor_name_en() {
        return productor_name_en;
    }

    public String getUnregister_reason() {
        return unregister_reason;
    }

    public String getAddre() {
        return addre;
    }

    public String getHealth_func() {
        return health_func;
    }

    public String getConstitute() {
        return constitute;
    }

    public String getMain_material() {
        return main_material;
    }

    public String getUnlimite_scope() {
        return unlimite_scope;
    }

    public String getLimite_scope() {
        return limite_scope;
    }

    public String getSpecification() {
        return specification;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public String getReserve_method() {
        return reserve_method;
    }

    public String getLookout() {
        return lookout;
    }

    public String getApproval_change_date() {
        return approval_change_date;
    }

    public String getChanged_content() {
        return changed_content;
    }

    public String getRecord_date() {
        return record_date;
    }

    public String getExchanger_name() {
        return exchanger_name;
    }

    public String getExchanger_name_en() {
        return exchanger_name_en;
    }

    public String getExchanger_addre() {
        return exchanger_addre;
    }

    public String getTaker() {
        return taker;
    }

    public String getTaker_addr() {
        return taker_addr;
    }

    public String getApproval_before() {
        return approval_before;
    }

    public String getExchange_date() {
        return exchange_date;
    }

    public String getSupplement_date() {
        return supplement_date;
    }

    public String getExtra_hint() {
        return extra_hint;
    }

    public String getProduct_name_en() {
        return product_name_en;
    }

    public String getApproval_date() {
        return approval_date;
    }

    public String getApplicant_chinese_name() {
        return applicant_chinese_name;
    }

    public String getProduct_sn() {
        return product_sn;
    }

    public String getApproval() {
        return approval;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getApplicant_name() {
        return applicant_name;
    }

    public String getApplicant_addre() {
        return applicant_addre;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getProduce_county() {
        return produce_county;
    }

    public String getUse_illustration() {
        return use_illustration;
    }

    public String getRecord_content() {
        return record_content;
    }

    public String getTaker_en() {
        return taker_en;
    }

    public String getValidate_date_to() {
        return validate_date_to;
    }

    public String getUnregister_date() {
        return unregister_date;
    }
}
