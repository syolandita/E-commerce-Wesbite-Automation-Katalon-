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

WebUI.callTestCase(findTestCase('Pendaftaran/TC-DFTR-02-01'), [('id') : 'hyacinth', ('password') : '+wFSVlolvcJfO6os+KmCCg=='], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Data Bank/tombol akun'))

WebUI.click(findTestObject('Data Bank/tombol data bank'))

WebUI.click(findTestObject('Data Bank/a_Tambahkan Rekening'))

WebUI.setText(findTestObject('Data Bank/input_Nama Bank'), bank)

WebUI.setText(findTestObject('Data Bank/input_No Rekening'), norek)

WebUI.setText(findTestObject('Data Bank/input_Atas Nama'), atasnama)

if (norek =~ '^[0-9]+$') {
    WebUI.click(findTestObject('Data Bank/button_Simpan Rekening Bank'))

    hasilNorek = WebUI.getText(findTestObject('Data Bank/hasil norek'))

    assert norek == hasilNorek // Menampilkan pesan kesalahan jika nomorKontak mengandung huruf atau karakter khusus
} else {
    WebUI.click(findTestObject('Data Bank/button_Simpan Rekening Bank'))

    WebUI.verifyTextPresent('Nomor rekening hanya boleh berisi angka!', false)
}

