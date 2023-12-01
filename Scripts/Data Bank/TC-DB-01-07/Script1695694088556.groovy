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
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Pendaftaran/TC-DFTR-02-01'), [('id') : 'hyacinth', ('password') : '+wFSVlolvcJfO6os+KmCCg=='], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Data Bank/tombol akun'))

WebUI.click(findTestObject('Data Bank/tombol data bank'))

List<WebElement> dataListBank = WebUI.findWebElements(findTestObject('Object Repository/Data Bank/hasil nama bank'), 10)

String[] arrNamaBank = new String[dataListBank.size()];

for (int i = 0; i < dataListBank.size(); i++) {
    arrNamaBank[i] = dataListBank.get(i).getText();
}

List<WebElement> dataListRek = WebUI.findWebElements(findTestObject('Object Repository/Data Bank/data norek'), 10);

String[] arrNoRek = new String[dataListRek.size()];

for (int i = 0; i < dataListRek.size(); i++) {
    arrNoRek[i] = dataListRek.get(i).getText();
}


WebUI.click(findTestObject('Data Bank/a_Tambahkan Rekening'))

WebUI.setText(findTestObject('Data Bank/input_Nama Bank'), bank)

WebUI.setText(findTestObject('Data Bank/input_No Rekening'), norek)

WebUI.setText(findTestObject('Data Bank/input_Atas Nama'), atasnama)

println('arrNamaBank:' + Arrays.toString(arrNamaBank))

println('arrNoRek:' + Arrays.toString(arrNoRek))

boolean dataSudahAda = false

for (int i = 0; i < arrNamaBank.length; i++) {
    if (bank.equals(arrNamaBank[i]) && norek.equals(arrNoRek[i])) {
        dataSudahAda = true

        break
    }
}

if (dataSudahAda) {
    WebUI.verifyTextPresent('Data bank dan nomor rekening sudah ada dalam daftar.', false)
} else {
    WebUI.click(findTestObject('Object Repository/Data Bank/button_Simpan Rekening Bank'))
}

