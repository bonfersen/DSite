package com.dsite.rest;

import java.math.BigDecimal;
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
import com.dsite.domain.model.views.VwReporteEconomicoExcel;
import com.dsite.dto.model.views.VwCrmFilter;
import com.dsite.dto.model.views.VwReporteEconomicoExcelFilter;
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
		int index = 1;
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

				report.addColumnValue(9, DateUtil.parseDateToString(item.getFechaCreacion(), DateUtil.DateFormat.DATE_SLASH), report.getCellStyle(0, 1));
				report.addColumnValue(10, item.getNombreReal());
				report.addColumnValue(11, item.getNumeroOrdenCompra());
				report.addColumnValue(12, item.getEstadoFinanzas());
				report.addColumnValue(13,
						ValidateUtil.isNotEmpty(item.getFechaLiquidacion()) ? DateUtil.parseDateToString(item.getFechaLiquidacion(), DateUtil.DateFormat.DATE_SLASH) : "", report.getCellStyle(0, 1));
				report.addColumnValue(14, item.getImportePresupuestoOferta(), report.getCellStyle(0, 0));
				report.addColumnValue(15, item.getImporteOferta(), report.getCellStyle(0, 0));
				report.addColumnValue(16, item.getImporteVariacionOferta(), report.getCellStyle(0, 0));
				report.addColumnValue(17, item.getImportePresupuestoLiquidacion(), report.getCellStyle(0, 0));
				report.addColumnValue(18, item.getImporteLiquidacion(), report.getCellStyle(0, 0));
				report.addColumnValue(19, item.getImporteVariacionLiquidacion(), report.getCellStyle(0, 0));
				report.addColumnValue(20, item.getEstadoActaCampo());
				report.addColumnValue(21, item.getEstadoActaFinal());
				report.addColumnValue(22, item.getEstadoActaAdministracion());
				report.addColumnValue(23, item.getImporteOrdenCompra(), report.getCellStyle(0, 0));
				report.addColumnValue(24, item.getNumeroOrdenCompra());
				report.addColumnValue(25, item.getCetificado());
				report.addColumnValue(26, item.getFacturaDSite());
				report.addColumnValue(27, item.getImporteVarMas(), report.getCellStyle(0, 0));
				report.addColumnValue(28, item.getImporteVarMenos(), report.getCellStyle(0, 0));
				report.addColumnValue(29, item.getImporteOrdenCompraComplementaria(), report.getCellStyle(0, 0));
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

	@RequestMapping(value = "/exportarExcelReporteEconomico", method = RequestMethod.POST)
	@ResponseBody
	public void exportarExcelReporteEconomico(@RequestBody VwReporteEconomicoExcelFilter filter, HttpServletResponse response) throws Exception {

		String templateFileName = "excel/ReporteEconomico.xlsx";

		downloadTemplateReporteEconomico(filter, response, templateFileName);
	}

	private void downloadTemplateReporteEconomico(VwReporteEconomicoExcelFilter filter, HttpServletResponse response, String templateFileName) throws Exception {
		ResponseEntity<List<VwReporteEconomicoExcel>> responseEntity = findReporteEconomicoExcel(filter);

		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			List<VwReporteEconomicoExcel> pageableResult = responseEntity.getBody();
			generateExcelReporteEconomico(response, templateFileName, pageableResult);
		}
	}

	private void generateExcelReporteEconomico(HttpServletResponse response, String templateFileName, List<VwReporteEconomicoExcel> pageableResult) throws Exception {
		TemplateExcelExporter report = new TemplateExcelExporter();

		loadRegistrosReporteEconomico(templateFileName, report, pageableResult);

		report.writeExcelToResponse(response, "Reporte CRM");

	}

	private void loadRegistrosReporteEconomico(String templateFileName, TemplateExcelExporter report, List<VwReporteEconomicoExcel> vwResult) throws Exception {
		Resource resource = resourceLoader.getResource("classpath:" + templateFileName);

		report.exportH(resource.getInputStream());
		int indexDetalle = 2;
		if (vwResult != null) {
			BigDecimal totalIngresos = BigDecimal.ZERO;
			BigDecimal montoOC = BigDecimal.ZERO;
			BigDecimal totalGastos = BigDecimal.ZERO;
			BigDecimal rentabilidad = BigDecimal.ZERO;
			BigDecimal porcentaje = BigDecimal.ZERO;
			for (VwReporteEconomicoExcel item : vwResult) {
				indexDetalle++;
				report.addRow(indexDetalle);
				report.addColumnValue(0, item.getCodigoDSite());
				report.addColumnValue(1, item.getArea());
				report.addColumnValue(2, item.getProyecto());
				report.addColumnValue(3, item.getNombreReal());
				report.addColumnValue(4, item.getImporteIngreso(), report.getCellStyle(0, 4));
				report.addColumnValue(5, item.getImporteIngresoOferta(), report.getCellStyle(0, 5));
				report.addColumnValue(6, item.getActas());
				report.addColumnValue(7, item.getFacturado());
				report.addColumnValue(8, item.getImporteGastos(), report.getCellStyle(0, 8));
				report.addColumnValue(9, item.getImporteRentabilidad(), report.getCellStyle(0, 9));
				report.addColumnValue(10, item.getPorcentajeRentabilidad(), report.getCellStyle(0, 10));

				if (ValidateUtil.isNotEmpty(item.getImporteIngreso()))
					totalIngresos = totalIngresos.add(item.getImporteIngreso());
				if (ValidateUtil.isNotEmpty(item.getImporteIngresoOferta()))
					montoOC = montoOC.add(item.getImporteIngresoOferta());
				if (ValidateUtil.isNotEmpty(item.getImporteGastos()))
					totalGastos = totalGastos.add(item.getImporteGastos());
				if (ValidateUtil.isNotEmpty(item.getImporteRentabilidad()))
					rentabilidad = rentabilidad.add(item.getImporteRentabilidad());
			}
			if (totalIngresos.compareTo(BigDecimal.ZERO) != 0) {
				porcentaje = rentabilidad.divide(totalIngresos, BigDecimal.ROUND_HALF_EVEN);
				porcentaje = porcentaje.setScale(2, BigDecimal.ROUND_HALF_EVEN);
			}
			
			report.setCellValue(0, 4, totalIngresos, report.getCellStyle(0, 4));
			report.setCellValue(0, 5, montoOC, report.getCellStyle(0, 5));
			report.setCellValue(0, 8, totalGastos, report.getCellStyle(0, 8));
			report.setCellValue(0, 9, rentabilidad, report.getCellStyle(0, 9));
			report.setCellValue(0, 10, porcentaje, report.getCellStyle(0, 10));
		}
	}

	@RequestMapping(value = "/findReporteEconomicoExcel", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwReporteEconomicoExcel>> findReporteEconomicoExcel(@RequestBody VwReporteEconomicoExcelFilter filter) {
		List<VwReporteEconomicoExcel> result;
		result = vistasService.findReporteEconomicoExcel(filter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
