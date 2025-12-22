---

# 📦 Tubes OOP Java – Kelompok 5

Aplikasi **Java berbasis Object Oriented Programming (OOP)** yang dikembangkan sebagai **Tugas Besar**.
Proyek ini menerapkan pemisahan antara **logika program (backend)** dan **antarmuka pengguna (GUI)** agar kode lebih terstruktur, mudah dipahami, dan mudah dikembangkan secara tim.

---

## 🧩 Deskripsi Proyek

Aplikasi ini merupakan sistem sederhana yang dibangun menggunakan **Java OOP** dengan penerapan konsep:

* Encapsulation
* Inheritance
* Polymorphism
* Exception Handling

Struktur proyek dipisahkan menjadi tiga bagian utama:

* **Backend** → logika dan proses bisnis aplikasi
* **GUI** → tampilan antarmuka pengguna (Java Swing)
* **MainApp** → titik awal (entry point) menjalankan aplikasi

---

## 📂 Struktur Repository

```plaintext
tubes-oop-java-kelompok5
├── src
│   ├── backend
│   │   ├── (class-class logika program)
│   │   └── (model, service, dan proses bisnis)
│   │
│   ├── gui
│   │   ├── (class tampilan / form Java Swing)
│   │   └── (event handling GUI)
│   │
│   └── mainapp
│       └── MainApp.java
│
├── README.md
├── .gitignore
```

---

## ⚙️ Penjelasan Folder

### 📁 `backend`

Berisi seluruh **logika aplikasi**, antara lain:

* Pengolahan data
* Class entity / model
* Proses bisnis
* Validasi input
* Exception handling

Backend **tidak bergantung langsung pada GUI**.

---

### 📁 `gui`

Berisi **antarmuka pengguna (User Interface)** menggunakan **Java Swing**, seperti:

* Form input data
* Button dan event listener
* Tampilan hasil/output

GUI akan berinteraksi dengan class-class di **backend**.

---

### 📁 `mainapp`

Berisi **class utama** sebagai titik awal menjalankan aplikasi.

Contoh:

```java
public class MainApp {
    public static void main(String[] args) {
        // Inisialisasi dan pemanggilan GUI
    }
}
```

---

## 🛠️ Teknologi yang Digunakan

* **Bahasa Pemrograman** : Java
* **Paradigma** : Object Oriented Programming (OOP)
* **GUI Framework** : Java Swing
* **Version Control** : Git & GitHub

---

## ▶️ Cara Menjalankan Program

1. **Clone repository**

   ```bash
   git clone https://github.com/Mahierhinandar26/tubes-oop-java-kelompok5.git
   ```

2. **Buka project di IDE**

   * IntelliJ IDEA
   * NetBeans
   * Eclipse

3. Pastikan **JDK sudah terinstal**

4. Jalankan file:

   ```
   src/mainapp/MainApp.java
   ```

---

## 👥 Anggota Kelompok

| Nama                         | Peran    |
| ---------------------------- | -------  |
| **Mahier Mohammad Hinandar** | Backend  |
| **Rochita Maulidina**        | GUI      |
| **Atila Ahmad Jilan**        | Integrasi|

---

## 📌 Catatan

* Struktur folder dibuat untuk memisahkan tanggung jawab kode
* Backend dan GUI dikembangkan pada branch terpisah lalu digabung ke `main`
* Folder `src` **tidak akan menjadi double** selama proses merge dilakukan dengan benar

---

## 📄 Lisensi

Proyek ini dibuat untuk **keperluan akademik** (Tugas Besar).

---
