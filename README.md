# Customized_Popup

Bir popup oluşturmak ve bunu özelleştirmek istediğimizde ilerlediğimiz adımları aşağıda sırasıyla belirtiyor olacağım.

# Main activity'de buton eklememiz gerekiyor.

****
`res / layout / main`

```
  <Button
                    android:id="@+id/customizedPopup"
                    android:layout_width="40dp"
                    android:layout_height="30dp"
                    android:layout_alignParentStart="true"
                    android:layout_alignParentTop="true"
                    android:layout_alignParentEnd="true"
                    android:layout_marginStart="55dp"
                    android:layout_marginTop="8dp"
                    android:layout_marginEnd="1dp"
                    android:layout_marginBottom="8dp"
                    android:background="@drawable/ic_launcher_phone"
                    android:onClick="popoverClicked"
                    android:text=""
                    android:textAlignment="center"
                    app:layout_constraintBottom_toBottomOf="parent"
                    app:layout_constraintEnd_toStartOf="@+id/start_logo"
                    app:layout_constraintHorizontal_bias="0.125"
                    app:layout_constraintStart_toStartOf="@+id/imageView12"
                    app:layout_constraintTop_toTopOf="parent"
                    app:layout_constraintVertical_bias="0.518" />

```
Main.java
Butona bastığımızda popup'ın çağırılması gerekiyor. Bunun için onClick'de belirtilen method block'unu özeleştirmemiz gerekiyor.
```
 public void popoverClicked(View view) {
        CustomizedPopup customizedPopup = new CustomizedPopup();
        customizedPopup.showPopup(this,view);

    }
```
****
# Kullanılan xml dosyaları


`res / layout / popup.xml`
`res / drawable / customized_frame.xml`

1.popup.xml

2.customized_frame.xml ( oluşturulan searchbar ve butonlar için )

****
# Popup 

`Utils / Customs / CustomizedPopup.java`

popupWindow -> Gösterilecek penceremiz.

popupContainer -> Belirtilen List'in her bir elemanı için oluşturulacak Butonlar için

scrollView -> Açılan pencerenin scroll özellliği kazanması için

searcView -> Açılan pencerede listelenen butonlar arasında search yapabilme özellği kazandırmak için 

oluşturulan nesnelerimiz.

En sonunda popup'ımızı ekranda gösterme işlemini gerçekleştiriyoruz.
****

# Popup Design
`Utils / Customs / PopupDesign.java`

popupDesign() -> İle birlikte popup penceresini özelleştirme işlemi yapıldı.

scrollDesign() -> ile birlikte popup penceresinin boyutu ayarlanarak scroll için sınır belirlendi

addAccountBtn () -> İle birlikte  listelenecek butonlar özelleştirildi

searchOperation () ve filterButtons() -> İle search işleminde arama özelliği işlemleri gerçekleştirildi


