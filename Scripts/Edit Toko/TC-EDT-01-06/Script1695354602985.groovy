import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Pendaftaran/TC-DFTR-02-01'), [('id') : 'Daphnee', ('password') : '+wFSVlolvcJfO6os+KmCCg=='], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Edit Toko/a_tombol menu toko'))

WebUI.click(findTestObject('Edit Toko/a_Pengaturan'))

WebUI.click(findTestObject('Edit Toko/a_tombol edit toko'))

WebUI.setText(findTestObject('Edit Toko/input_Nama Toko'), namaToko)

if (namaToko =~ '^(?=.*[a-zA-Z])(?=.*\\d).+$') {
    WebUI.click(findTestObject('Edit Toko/tombol simpan perubahan'))

    hasilNamaToko = WebUI.getText(findTestObject('Edit Toko/verifikasi nama toko'))

    assert namaToko == hasilNamaToko
} else {
    WebUI.click(findTestObject('Edit Toko/tombol simpan perubahan'))

    WebUI.verifyTextPresent('Nama toko tidak boleh hanya angka!', false)
}

