# 🐦 Tweets App

An Android application that fetches and displays tweets based on selected categories using a JSONBin API.

---

## 📱 Features

* 🔍 Fetch tweets dynamically from JSONBin API
* 🗂️ View tweets by category
* ⚡ Smooth and responsive UI with Jetpack Compose
* 🔄 Real-time data updates
* 🧭 Clean and scalable architecture (MVVM)

---

## 🏗️ Tech Stack

* **Language:** Kotlin
* **UI:** Jetpack Compose
* **Architecture:** MVVM (Model-View-ViewModel)
* **Networking:** Retrofit / OkHttp
* **Async:** Coroutines + Flow
* **Dependency Injection:** (Hilt/Dagger)

---

## 🌐 API

This app uses a JSONBin endpoint to fetch tweets data.

* Categories Endpoint: `https://api.jsonbin.io/v3/b/69c4d7f9c3097a1dd55f9a74?meta=false`
* Tweets Endpoint: `https://api.jsonbin.io/v3/b/69c25becaa77b81da91406df?meta=false`
* Data is structured category-wise and parsed into UI models.

---

## 📂 Project Structure

```
├── api
├── di
├── models
├── repo
├── screens
├── ui.theme
├── utils
├── viewmodels
```

---

## 🚀 Getting Started

### 1. Clone the repository

```
git clone https://github.com/Android-Projects-Kotlin/TweetsApp.git
```

### 2. Open in Android Studio

### 3. Run the app

* Connect a device or start an emulator
* Click ▶️ Run

---

## 🤝 Contributing

Feel free to fork this repo and submit pull requests.


## 🙌 Acknowledgements

* JSONBin for mock API
* Android Jetpack libraries
* Open-source community

---

## 👨‍💻 Author

**Kanishka Soni**
