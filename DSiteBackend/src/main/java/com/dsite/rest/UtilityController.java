package com.dsite.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dsite.domain.model.views.VwCrm;
import com.dsite.dto.model.views.VwCrmFilter;
import com.dsite.service.intf.VistasService;
import com.dsite.util.DateUtil;
import com.dsite.util.TemplateExcelExporter;
import com.dsite.util.ValidateUtil;

@RestController
@RequestMapping(value = "/api/utility")
public class UtilityController {

	@Autowired
	VistasService vistasService;

	@Autowired
	private ResourceLoader resourceLoader;

	private static final Logger LOGGER = LoggerFactory.getLogger(UtilityController.class);

	@RequestMapping(value = "/exportarExcelCRM", method = RequestMethod.POST)
	@ResponseBody
	public void exportarExcelCRM(@RequestBody VwCrmFilter crmFilter, HttpServletResponse response) throws Exception {

		String templateFileName = "excel/CRM.xlsx";

		downloadTemplateCRM(crmFilter, response, templateFileName);
	}

	private void downloadTemplateCRM(VwCrmFilter crmFilter, HttpServletResponse response, String templateFileName) throws Exception {
		ResponseEntity<List<VwCrm>> responseEntity = findCrmExcel(crmFilter);

		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			List<VwCrm> pageableResult = responseEntity.getBody();
			generateExcelCRM(response, templateFileName, pageableResult);
		}
	}

	private void generateExcelCRM(HttpServletResponse response, String templateFileName, List<VwCrm> pageableResult) throws Exception {
		TemplateExcelExporter report = new TemplateExcelExporter();

		loadRegistrosCRM(templateFileName, report, pageableResult);

		report.writeExcelToResponse(response, "Reporte CRM");

	}

	private void loadRegistrosCRM(String templateFileName, TemplateExcelExporter report, List<VwCrm> vwCrmResult) throws Exception {
		Resource resource = resourceLoader.getResource("classpath:" + templateFileName);

		report.exportH(resource.getInputStream());
		int index = 0;
		if (vwCrmResult != null) {
			for (VwCrm item : vwCrmResult) {
				index++;
				report.addRow(index);
				report.addColumnValue(0, item.getCodigoDSite());
				report.addColumnValue(1, item.getCorrelativoOfertaLiquidacion());
				report.addColumnValue(2, item.getArea());
				report.addColumnValue(3, item.getProyecto());
				report.addColumnValue(4, item.getGestorProyecto());
				report.addColumnValue(5, item.getGerenteProyecto());
				report.addColumnValue(6, item.getOTAutogenerada());
				report.addColumnValue(7, item.getDepartamento());
				report.addColumnValue(8, item.getTipoGasto());

				report.addColumnValue(9, DateUtil.parseDateToString(item.getFechaCreacion(), DateUtil.DateFormat.DATE_TIME_SLASH));
				report.addColumnValue(10, item.getNombreReal());
				report.addColumnValue(11, item.getNumeroOrdenCompra());
				report.addColumnValue(12, item.getEstadoFinanzas());
				report.addColumnValue(13,
						ValidateUtil.isNotEmpty(item.getFechaLiquidacion()) ? DateUtil.parseDateToString(item.getFechaLiquidacion(), DateUtil.DateFormat.DATE_TIME_SLASH) : "");
				report.addColumnValue(14, item.getImportePresupuestoOferta());
				report.addColumnValue(15, item.getImporteOferta());
				report.addColumnValue(16, item.getImporteVariacionOferta());
				report.addColumnValue(17, item.getImportePresupuestoLiquidacion());
				report.addColumnValue(18, item.getImporteLiquidacion());
				report.addColumnValue(19, item.getImporteVariacionLiquidacion());
				report.addColumnValue(20, item.getActaCampo());
				report.addColumnValue(21, item.getActaFinal());
				report.addColumnValue(22, item.getEstadoActaAdministracion());
				report.addColumnValue(23, item.getImporteOrdenCompra());
				report.addColumnValue(24, item.getNumeroOrdenCompra());
				report.addColumnValue(25, item.getCetificado());
				report.addColumnValue(26, item.getFacturaDSite());
				report.addColumnValue(27, item.getImporteVarMas());
				report.addColumnValue(28, item.getImporteVarMenos());
				report.addColumnValue(29, item.getImporteOrdenCompraComplementaria());
				report.addColumnValue(30, item.getNumeroOrdenCompraComplementaria());
				report.addColumnValue(31, item.getCetificadoComplementaria());
				report.addColumnValue(32, item.getFacturaDSiteComplementaria());
				report.addColumnValue(33, item.getNotaCredito());
			}
		}
	}

	@RequestMapping(value = "/findCrmExcel", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwCrm>> findCrmExcel(@RequestBody VwCrmFilter vwCrmFilter) {
		List<VwCrm> result;
		result = vistasService.findCrmExcel(vwCrmFilter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
