# 学生管理システム

## 機能

1. 学生情報表示![image-20220620134851019](https://user-images.githubusercontent.com/57182515/174953184-e354de93-cb49-4a4e-9ea1-8b401b71c439.png)

2. 学生情報追加
![image-20220620135305712](https://user-images.githubusercontent.com/57182515/174953230-dc71ad86-0894-4e6c-93cf-d6c024cb32af.png)


3. 学生情報編集

![image-20220620135407280](https://user-images.githubusercontent.com/57182515/174953271-92d4bcc2-44d0-40d0-8dbd-8a830c5d2efa.png)


4. 学生情報削除

![image-20220620135600752](https://user-images.githubusercontent.com/57182515/174953313-727e57a2-1b6a-44af-b0a9-dca15944a0e8.png)




## 開発

### フロントエンド

フロントエンドフレームワークVueで実現した。


![image-20220620140220168](https://user-images.githubusercontent.com/57182515/174953343-6f8eb05e-6653-4c37-8cc4-84451e56591d.png)



#### ファイル

AddStudent.vue:　学生追加画面を作成する

index.vue:　ルーターを表示する

StudentInformation.vue:　学生情報表示画面を作成する

StudentUpdate.vue:　学生情報更新画面を作成する

index.js:　ルーターの設定と管理ファイルです

APP.vue: 　ルーターを実現した主要コンポーネントである。すべてのページは、App.vueで切り替えられる。

main.js :　エントリファイルで、Vueインスタンスを初期化し、必要なプラグインを導入する

### バックエンド

バックエンドフレームワークspring bootとKotlin言語で実現した。データベースはH2です。

![image-20220622140840434](https://user-images.githubusercontent.com/57182515/174953401-5b87100b-b582-4581-8bb6-ac82632055df.png)


#### ファイル

h2db:　インメモリh2データベース

StudentsHandler.kt:　フロントエンドからのHTTP Request（GET、PUT、POST、DELETE）を処理してリスポンスする

Sthdent:　データベースのテーブルからEntityにマッピングする

StudentRepository:　テーブルに対する操作Create、Read、Update、DeleteをCrudRepositoryから継承するInterfaceです。

SpringboottestApplication.kt:　メインプログラムです。プロジェクトの実行はここから始まる

static:　フロントエンドの静的ファイル

application.properties: 　DBの接続情報などアプリケーションに関する設定を記述する

## スタート

1. npm run dev でフロントエンドのプログラムが実行できる。詳しくはフロントエンドプログラムのReadme.mdを参考してください。フロントエンドポートは8081です。バックエンドのプログラムはSpringboottestApplication.ktから実行できる。バックエンドポートは8080です。バックエンドのプログラムを実行した後に、URL：localhost:8081にアクセスすればシステムを操作できる。
2. バックエンドプログラムのstaticにフロントエンドの静的ファイルが入っているので、バックエンドを起動するだけで、URL：localhost:8080にアクセスしてシステムを操作できる。
3. 
