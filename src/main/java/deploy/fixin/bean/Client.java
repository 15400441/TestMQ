package deploy.fixin.bean;

import java.util.Date;

public class Client {
	private String client_id;
	private String sender_comp_id;
	private String sender_sub_comp_id;
	private String sender_location_id;
	private String obf_comp_id;
	private String obf_sub_comp_id;
	private String obf_location_id;
	private String target_comp_id;
	private String target_sub_comp_id;
	private String target_location_id;
	private String dt_comp_id;
	private String dt_sub_comp_id;
	private String dt_location_id;
	private String name;
	private Character status;
	private Character send_pend_new;
	private Character unsol_new;
	private Character unsol_modify;
	private Character unsol_cancel;
	private Integer client_sub_id;
	private String target_client_id;
	private Date last_update;
	private String fix_appl_version;
	
	
	public static Client genTemplateClient(){
		Client c=new Client();
		c.setStatus('A');
		c.setSend_pend_new('Y');
		c.setUnsol_new('N');
		c.setUnsol_modify('Y');
		c.setUnsol_cancel('Y');
		return c;
	}
	
	
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getSender_comp_id() {
		return sender_comp_id;
	}
	public void setSender_comp_id(String sender_comp_id) {
		this.sender_comp_id = sender_comp_id;
	}
	public String getSender_sub_comp_id() {
		return sender_sub_comp_id;
	}
	public void setSender_sub_comp_id(String sender_sub_comp_id) {
		this.sender_sub_comp_id = sender_sub_comp_id;
	}
	public String getSender_location_id() {
		return sender_location_id;
	}
	public void setSender_location_id(String sender_location_id) {
		this.sender_location_id = sender_location_id;
	}
	public String getObf_comp_id() {
		return obf_comp_id;
	}
	public void setObf_comp_id(String obf_comp_id) {
		this.obf_comp_id = obf_comp_id;
	}
	public String getObf_sub_comp_id() {
		return obf_sub_comp_id;
	}
	public void setObf_sub_comp_id(String obf_sub_comp_id) {
		this.obf_sub_comp_id = obf_sub_comp_id;
	}
	public String getObf_location_id() {
		return obf_location_id;
	}
	public void setObf_location_id(String obf_location_id) {
		this.obf_location_id = obf_location_id;
	}
	public String getTarget_comp_id() {
		return target_comp_id;
	}
	public void setTarget_comp_id(String target_comp_id) {
		this.target_comp_id = target_comp_id;
	}
	public String getTarget_sub_comp_id() {
		return target_sub_comp_id;
	}
	public void setTarget_sub_comp_id(String target_sub_comp_id) {
		this.target_sub_comp_id = target_sub_comp_id;
	}
	public String getTarget_location_id() {
		return target_location_id;
	}
	public void setTarget_location_id(String target_location_id) {
		this.target_location_id = target_location_id;
	}
	public String getDt_comp_id() {
		return dt_comp_id;
	}
	public void setDt_comp_id(String dt_comp_id) {
		this.dt_comp_id = dt_comp_id;
	}
	public String getDt_sub_comp_id() {
		return dt_sub_comp_id;
	}
	public void setDt_sub_comp_id(String dt_sub_comp_id) {
		this.dt_sub_comp_id = dt_sub_comp_id;
	}
	public String getDt_location_id() {
		return dt_location_id;
	}
	public void setDt_location_id(String dt_location_id) {
		this.dt_location_id = dt_location_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	public Character getSend_pend_new() {
		return send_pend_new;
	}
	public void setSend_pend_new(Character send_pend_new) {
		this.send_pend_new = send_pend_new;
	}
	public Character getUnsol_new() {
		return unsol_new;
	}
	public void setUnsol_new(Character unsol_new) {
		this.unsol_new = unsol_new;
	}
	public Character getUnsol_modify() {
		return unsol_modify;
	}
	public void setUnsol_modify(Character unsol_modify) {
		this.unsol_modify = unsol_modify;
	}
	public Character getUnsol_cancel() {
		return unsol_cancel;
	}
	public void setUnsol_cancel(Character unsol_cancel) {
		this.unsol_cancel = unsol_cancel;
	}
	public Integer getClient_sub_id() {
		return client_sub_id;
	}
	public void setClient_sub_id(Integer client_sub_id) {
		this.client_sub_id = client_sub_id;
	}
	public String getTarget_client_id() {
		return target_client_id;
	}
	public void setTarget_client_id(String target_client_id) {
		this.target_client_id = target_client_id;
	}
	public Date getLast_update() {
		return last_update;
	}
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
	public String getFix_appl_version() {
		return fix_appl_version;
	}
	public void setFix_appl_version(String fix_appl_version) {
		this.fix_appl_version = fix_appl_version;
	}
	@Override
	public String toString() {
		return "Client [client_id=" + client_id + ", sender_comp_id=" + sender_comp_id + ", sender_sub_comp_id="
				+ sender_sub_comp_id + ", sender_location_id=" + sender_location_id + ", obf_comp_id=" + obf_comp_id
				+ ", obf_sub_comp_id=" + obf_sub_comp_id + ", obf_location_id=" + obf_location_id + ", target_comp_id="
				+ target_comp_id + ", target_sub_comp_id=" + target_sub_comp_id + ", target_location_id="
				+ target_location_id + ", dt_comp_id=" + dt_comp_id + ", dt_sub_comp_id=" + dt_sub_comp_id
				+ ", dt_location_id=" + dt_location_id + ", name=" + name + ", status=" + status + ", send_pend_new="
				+ send_pend_new + ", unsol_new=" + unsol_new + ", unsol_modify=" + unsol_modify + ", unsol_cancel="
				+ unsol_cancel + ", client_sub_id=" + client_sub_id + ", target_client_id=" + target_client_id
				+ ", last_update=" + last_update + ", fix_appl_version=" + fix_appl_version + "]";
	}
	
	
	
	
	

}
