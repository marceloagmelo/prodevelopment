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

package br.com.prodevelopment.funcionario.service.persistence;

import br.com.prodevelopment.funcionario.model.Funcionario;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.ExportImportHelperUtil;
import com.liferay.portal.kernel.lar.ManifestSummary;
import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.util.PortalUtil;

/**
 * @author Marcelo Melo
 * @generated
 */
public class FuncionarioExportActionableDynamicQuery
	extends FuncionarioActionableDynamicQuery {
	public FuncionarioExportActionableDynamicQuery(
		PortletDataContext portletDataContext) throws SystemException {
		_portletDataContext = portletDataContext;

		setCompanyId(_portletDataContext.getCompanyId());
	}

	@Override
	public long performCount() throws PortalException, SystemException {
		ManifestSummary manifestSummary = _portletDataContext.getManifestSummary();

		StagedModelType stagedModelType = getStagedModelType();

		long modelAdditionCount = super.performCount();

		manifestSummary.addModelAdditionCount(stagedModelType.toString(),
			modelAdditionCount);

		long modelDeletionCount = ExportImportHelperUtil.getModelDeletionCount(_portletDataContext,
				stagedModelType);

		manifestSummary.addModelDeletionCount(stagedModelType.toString(),
			modelDeletionCount);

		return modelAdditionCount;
	}

	@Override
	protected void addCriteria(DynamicQuery dynamicQuery) {
		_portletDataContext.addDateRangeCriteria(dynamicQuery, "modifiedDate");
	}

	protected StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Funcionario.class.getName()));
	}

	@Override
	@SuppressWarnings("unused")
	protected void performAction(Object object)
		throws PortalException, SystemException {
		Funcionario stagedModel = (Funcionario)object;

		StagedModelDataHandlerUtil.exportStagedModel(_portletDataContext,
			stagedModel);
	}

	private PortletDataContext _portletDataContext;
}