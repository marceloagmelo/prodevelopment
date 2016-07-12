/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package br.com.prodevelopment.contato.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Contato}.
 * </p>
 *
 * @author Marcelo Melo
 * @see Contato
 * @generated
 */
public class ContatoWrapper implements Contato, ModelWrapper<Contato> {
	public ContatoWrapper(Contato contato) {
		_contato = contato;
	}

	@Override
	public Class<?> getModelClass() {
		return Contato.class;
	}

	@Override
	public String getModelClassName() {
		return Contato.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contatoId", getContatoId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("accountId", getAccountId());
		attributes.put("endEmail", getEndEmail());
		attributes.put("nome", getNome());
		attributes.put("sexo", getSexo());
		attributes.put("dataNascimento", getDataNascimento());
		attributes.put("cargoId", getCargoId());
		attributes.put("skype", getSkype());
		attributes.put("facebook", getFacebook());
		attributes.put("twitter", getTwitter());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contatoId = (Long)attributes.get("contatoId");

		if (contatoId != null) {
			setContatoId(contatoId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long createUserId = (Long)attributes.get("createUserId");

		if (createUserId != null) {
			setCreateUserId(createUserId);
		}

		Long modifiedUserId = (Long)attributes.get("modifiedUserId");

		if (modifiedUserId != null) {
			setModifiedUserId(modifiedUserId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		String endEmail = (String)attributes.get("endEmail");

		if (endEmail != null) {
			setEndEmail(endEmail);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String sexo = (String)attributes.get("sexo");

		if (sexo != null) {
			setSexo(sexo);
		}

		Date dataNascimento = (Date)attributes.get("dataNascimento");

		if (dataNascimento != null) {
			setDataNascimento(dataNascimento);
		}

		Long cargoId = (Long)attributes.get("cargoId");

		if (cargoId != null) {
			setCargoId(cargoId);
		}

		String skype = (String)attributes.get("skype");

		if (skype != null) {
			setSkype(skype);
		}

		String facebook = (String)attributes.get("facebook");

		if (facebook != null) {
			setFacebook(facebook);
		}

		String twitter = (String)attributes.get("twitter");

		if (twitter != null) {
			setTwitter(twitter);
		}
	}

	/**
	* Returns the primary key of this contato.
	*
	* @return the primary key of this contato
	*/
	@Override
	public long getPrimaryKey() {
		return _contato.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contato.
	*
	* @param primaryKey the primary key of this contato
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_contato.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the contato ID of this contato.
	*
	* @return the contato ID of this contato
	*/
	@Override
	public long getContatoId() {
		return _contato.getContatoId();
	}

	/**
	* Sets the contato ID of this contato.
	*
	* @param contatoId the contato ID of this contato
	*/
	@Override
	public void setContatoId(long contatoId) {
		_contato.setContatoId(contatoId);
	}

	/**
	* Returns the company ID of this contato.
	*
	* @return the company ID of this contato
	*/
	@Override
	public long getCompanyId() {
		return _contato.getCompanyId();
	}

	/**
	* Sets the company ID of this contato.
	*
	* @param companyId the company ID of this contato
	*/
	@Override
	public void setCompanyId(long companyId) {
		_contato.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this contato.
	*
	* @return the group ID of this contato
	*/
	@Override
	public long getGroupId() {
		return _contato.getGroupId();
	}

	/**
	* Sets the group ID of this contato.
	*
	* @param groupId the group ID of this contato
	*/
	@Override
	public void setGroupId(long groupId) {
		_contato.setGroupId(groupId);
	}

	/**
	* Returns the create user ID of this contato.
	*
	* @return the create user ID of this contato
	*/
	@Override
	public long getCreateUserId() {
		return _contato.getCreateUserId();
	}

	/**
	* Sets the create user ID of this contato.
	*
	* @param createUserId the create user ID of this contato
	*/
	@Override
	public void setCreateUserId(long createUserId) {
		_contato.setCreateUserId(createUserId);
	}

	/**
	* Returns the create user uuid of this contato.
	*
	* @return the create user uuid of this contato
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contato.getCreateUserUuid();
	}

	/**
	* Sets the create user uuid of this contato.
	*
	* @param createUserUuid the create user uuid of this contato
	*/
	@Override
	public void setCreateUserUuid(java.lang.String createUserUuid) {
		_contato.setCreateUserUuid(createUserUuid);
	}

	/**
	* Returns the modified user ID of this contato.
	*
	* @return the modified user ID of this contato
	*/
	@Override
	public long getModifiedUserId() {
		return _contato.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this contato.
	*
	* @param modifiedUserId the modified user ID of this contato
	*/
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_contato.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this contato.
	*
	* @return the modified user uuid of this contato
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contato.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this contato.
	*
	* @param modifiedUserUuid the modified user uuid of this contato
	*/
	@Override
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_contato.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the create date of this contato.
	*
	* @return the create date of this contato
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _contato.getCreateDate();
	}

	/**
	* Sets the create date of this contato.
	*
	* @param createDate the create date of this contato
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_contato.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this contato.
	*
	* @return the modified date of this contato
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _contato.getModifiedDate();
	}

	/**
	* Sets the modified date of this contato.
	*
	* @param modifiedDate the modified date of this contato
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_contato.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the fully qualified class name of this contato.
	*
	* @return the fully qualified class name of this contato
	*/
	@Override
	public java.lang.String getClassName() {
		return _contato.getClassName();
	}

	@Override
	public void setClassName(java.lang.String className) {
		_contato.setClassName(className);
	}

	/**
	* Returns the class name ID of this contato.
	*
	* @return the class name ID of this contato
	*/
	@Override
	public long getClassNameId() {
		return _contato.getClassNameId();
	}

	/**
	* Sets the class name ID of this contato.
	*
	* @param classNameId the class name ID of this contato
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_contato.setClassNameId(classNameId);
	}

	/**
	* Returns the class p k of this contato.
	*
	* @return the class p k of this contato
	*/
	@Override
	public long getClassPK() {
		return _contato.getClassPK();
	}

	/**
	* Sets the class p k of this contato.
	*
	* @param classPK the class p k of this contato
	*/
	@Override
	public void setClassPK(long classPK) {
		_contato.setClassPK(classPK);
	}

	/**
	* Returns the account ID of this contato.
	*
	* @return the account ID of this contato
	*/
	@Override
	public long getAccountId() {
		return _contato.getAccountId();
	}

	/**
	* Sets the account ID of this contato.
	*
	* @param accountId the account ID of this contato
	*/
	@Override
	public void setAccountId(long accountId) {
		_contato.setAccountId(accountId);
	}

	/**
	* Returns the end email of this contato.
	*
	* @return the end email of this contato
	*/
	@Override
	public java.lang.String getEndEmail() {
		return _contato.getEndEmail();
	}

	/**
	* Sets the end email of this contato.
	*
	* @param endEmail the end email of this contato
	*/
	@Override
	public void setEndEmail(java.lang.String endEmail) {
		_contato.setEndEmail(endEmail);
	}

	/**
	* Returns the nome of this contato.
	*
	* @return the nome of this contato
	*/
	@Override
	public java.lang.String getNome() {
		return _contato.getNome();
	}

	/**
	* Sets the nome of this contato.
	*
	* @param nome the nome of this contato
	*/
	@Override
	public void setNome(java.lang.String nome) {
		_contato.setNome(nome);
	}

	/**
	* Returns the sexo of this contato.
	*
	* @return the sexo of this contato
	*/
	@Override
	public java.lang.String getSexo() {
		return _contato.getSexo();
	}

	/**
	* Sets the sexo of this contato.
	*
	* @param sexo the sexo of this contato
	*/
	@Override
	public void setSexo(java.lang.String sexo) {
		_contato.setSexo(sexo);
	}

	/**
	* Returns the data nascimento of this contato.
	*
	* @return the data nascimento of this contato
	*/
	@Override
	public java.util.Date getDataNascimento() {
		return _contato.getDataNascimento();
	}

	/**
	* Sets the data nascimento of this contato.
	*
	* @param dataNascimento the data nascimento of this contato
	*/
	@Override
	public void setDataNascimento(java.util.Date dataNascimento) {
		_contato.setDataNascimento(dataNascimento);
	}

	/**
	* Returns the cargo ID of this contato.
	*
	* @return the cargo ID of this contato
	*/
	@Override
	public long getCargoId() {
		return _contato.getCargoId();
	}

	/**
	* Sets the cargo ID of this contato.
	*
	* @param cargoId the cargo ID of this contato
	*/
	@Override
	public void setCargoId(long cargoId) {
		_contato.setCargoId(cargoId);
	}

	/**
	* Returns the skype of this contato.
	*
	* @return the skype of this contato
	*/
	@Override
	public java.lang.String getSkype() {
		return _contato.getSkype();
	}

	/**
	* Sets the skype of this contato.
	*
	* @param skype the skype of this contato
	*/
	@Override
	public void setSkype(java.lang.String skype) {
		_contato.setSkype(skype);
	}

	/**
	* Returns the facebook of this contato.
	*
	* @return the facebook of this contato
	*/
	@Override
	public java.lang.String getFacebook() {
		return _contato.getFacebook();
	}

	/**
	* Sets the facebook of this contato.
	*
	* @param facebook the facebook of this contato
	*/
	@Override
	public void setFacebook(java.lang.String facebook) {
		_contato.setFacebook(facebook);
	}

	/**
	* Returns the twitter of this contato.
	*
	* @return the twitter of this contato
	*/
	@Override
	public java.lang.String getTwitter() {
		return _contato.getTwitter();
	}

	/**
	* Sets the twitter of this contato.
	*
	* @param twitter the twitter of this contato
	*/
	@Override
	public void setTwitter(java.lang.String twitter) {
		_contato.setTwitter(twitter);
	}

	@Override
	public boolean isNew() {
		return _contato.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_contato.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _contato.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_contato.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _contato.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _contato.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contato.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contato.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_contato.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_contato.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contato.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContatoWrapper((Contato)_contato.clone());
	}

	@Override
	public int compareTo(br.com.prodevelopment.contato.model.Contato contato) {
		return _contato.compareTo(contato);
	}

	@Override
	public int hashCode() {
		return _contato.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.prodevelopment.contato.model.Contato> toCacheModel() {
		return _contato.toCacheModel();
	}

	@Override
	public br.com.prodevelopment.contato.model.Contato toEscapedModel() {
		return new ContatoWrapper(_contato.toEscapedModel());
	}

	@Override
	public br.com.prodevelopment.contato.model.Contato toUnescapedModel() {
		return new ContatoWrapper(_contato.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contato.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _contato.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contato.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContatoWrapper)) {
			return false;
		}

		ContatoWrapper contatoWrapper = (ContatoWrapper)obj;

		if (Validator.equals(_contato, contatoWrapper._contato)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Contato getWrappedContato() {
		return _contato;
	}

	@Override
	public Contato getWrappedModel() {
		return _contato;
	}

	@Override
	public void resetOriginalValues() {
		_contato.resetOriginalValues();
	}

	private Contato _contato;
}