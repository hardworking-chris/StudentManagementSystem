<template>
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm" size="medium">
  <el-form-item label="学生名字" prop="name" style="width: 50%;">
    <el-input v-model="ruleForm.name"></el-input>
  </el-form-item>
  <el-form-item label="担任先生" prop="classTeacher" style="width: 50%;" required>
    <el-input v-model="ruleForm.classTeacher"></el-input>
  </el-form-item>
  <el-form-item label="状態" prop="status" required>
    <el-select v-model="ruleForm.status" placeholder="状態を選んでください">
      <el-option label="正常" value="正常"></el-option>
      <el-option label="合格" value="合格"></el-option>
      <el-option label="音信不通" value="音信不通"></el-option>
      <el-option label="放棄" value="放棄"></el-option>
      <el-option label="仮面浪人" value="仮面浪人"></el-option>
    </el-select>
  </el-form-item>
  <el-form-item label="生年月日" required>
    <el-form-item prop="birthday" style="width: 20%;">
      <el-date-picker  type="date" placeholder="日付を選んでください" v-model="ruleForm.birthday" style="width: 100%;"></el-date-picker>
    </el-form-item>
  </el-form-item>
  <el-form-item label="電話番号" prop="phone" style="width: 30%;" required>
    <el-input v-model="ruleForm.phone"></el-input>
  </el-form-item>
  <el-form-item label="QQ番号" prop="qq" style="width: 30%;" required>
    <el-input v-model="ruleForm.qq"></el-input>
  </el-form-item>
  <el-form-item label="入塾時間" required>
    <el-form-item prop="entryDate" style="width: 20%;">
      <el-date-picker  type="date" placeholder="日付を選んでください" v-model="ruleForm.entryDate" style="width: 100%;"></el-date-picker>
    </el-form-item>
  </el-form-item>
  <el-form-item label="卒業時間" required>
  <el-form-item prop="graduateDate" style="width: 20%;">
    <el-date-picker  type="date" placeholder="日付を選んでください" v-model="ruleForm.graduateDate" style="width: 100%;"></el-date-picker>
  </el-form-item>
  </el-form-item>
  <el-form-item label="卒業学校" prop="graduateSchool" style="width: 30%;" required>
    <el-input v-model="ruleForm.graduateSchool"></el-input>
  </el-form-item>
  <el-form-item label="卒業専攻" prop="major" style="width: 30%;" required>
    <el-input v-model="ruleForm.major"></el-input>
  </el-form-item>
  <el-form-item label="日本語成績" prop="japanese">
    <el-radio-group v-model="ruleForm.japanese">
      <el-radio label="N1" name="japanese"></el-radio>
      <el-radio label="N2" name="japanese"></el-radio>
      <el-radio label="N3-N5" name="japanese"></el-radio>
      <el-radio label="なし" name="japanese"></el-radio>
    </el-radio-group>
  </el-form-item>
  <el-form-item label="英語成績" prop="englishTemp">
    <el-checkbox-group v-model="ruleForm.englishTemp">
      <el-checkbox label="TOEFL" name="englishTemp" ></el-checkbox>
      <el-checkbox label="TOEIC" name="englishTemp" ></el-checkbox>
      <el-checkbox label="大学英語四级" name="englishTemp"></el-checkbox>
      <el-checkbox label="大学英語六级" name="englishTemp"></el-checkbox>
      <el-checkbox label="なし" name="englishTemp"></el-checkbox>
    </el-checkbox-group>
  </el-form-item>
  <el-form-item
    v-for="testName in ruleForm.englishTemp"
    v-if="testName !== 'なし'"
    :label="testName"
    :key = "testName.key"
    style="width: 30%;"
    :prop="'scores.'+ testName"
    :rules="[
      {required: true, message: '英語成績を入力してください。', trigger: 'blur'},
      {min: 1, max: 50, message: '卒業学校は50文字以内で入力してください。', trigger: 'blur'}]
    ">
    <el-input v-model="ruleForm.scores[testName]"></el-input>
  </el-form-item>

  <el-form-item label="备注" prop="note">
    <el-input type="textarea" v-model="ruleForm.note"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="submitForm('ruleForm')">学生追加</el-button>
    <el-button @click="resetForm('ruleForm')">重置</el-button>
  </el-form-item>
  </el-form>
</template>
<script>
import axios from 'axios'

export default {
  data () {
    return {
      ruleForm: {
        name: '',
        classTeacher: '',
        status: '',
        birthday: '',
        entryDate: '',
        graduateDate: '',
        graduateSchool: '',
        phone: '',
        major: '',
        qq: '',
        note: '',
        englishTemp: [],
        english: '',
        scores: {
          'TOEFL': '',
          'TOEIC': '',
          'englishFour': '',
          'englishSix': '',
          'noScores': ''
        },
        japanese: ''
      },
      rules: {
        name: [
          {required: true, message: '姓名を入力してください。', trigger: 'blur'},
          {min: 1, max: 40, message: '氏名は40文字以内で入力してください。', trigger: 'blur'}
        ],
        classTeacher: [
          {required: true, message: '姓名を入力してください。', trigger: 'blur'},
          {min: 1, max: 40, message: '氏名は40文字以内で入力してください。', trigger: 'blur'}
        ],
        status: [
          {required: true, message: '状態を選んでください。', trigger: 'change'}
        ],
        birthday: [
          {type: 'date', required: true, message: '日付を選んでください', trigger: 'change'}
        ],
        entryDate: [
          {type: 'date', required: true, message: '日付を選んでください', trigger: 'change'}
        ],
        graduateDate: [
          {type: 'date', required: true, message: '日付を選んでください', trigger: 'change'}
        ],
        graduateSchool: [
          {required: true, message: '卒業学校を入力してください。', trigger: 'blur'},
          {min: 1, max: 100, message: '卒業学校は100文字以内で入力してください。', trigger: 'blur'}
        ],
        major: [
          {required: true, message: '卒業専攻を入力してください。', trigger: 'blur'},
          {min: 1, max: 50, message: '卒業専攻は50文字以内で入力してください。', trigger: 'blur'}
        ],
        note: [
          {min: 1, max: 100, message: 'メモは100文字以内で入力してください。', trigger: 'blur'}
        ],
        phone: [
          {required: true, message: '電話番号を入力してください。', trigger: 'blur'},
          {min: 1, max: 20, message: '電話番号は20桁以内で入力してください。', trigger: 'blur'}
        ],
        qq: [
          {required: true, message: 'QQ番号を入力してください。', trigger: 'blur'},
          {min: 1, max: 20, message: 'QQ番号は20桁以内で入力してください。', trigger: 'blur'}
        ],
        englishTemp: [
          {type: 'array', required: true, message: '英語成績は少なくとも1つ選択してください。', trigger: 'change'}
        ],
        japanese: [
          {required: true, message: '日本語成績を選んでください。', trigger: 'change'}
        ]
      }
    }
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          for (let i = 0; i < this.ruleForm.englishTemp.length; i++) {
            this.ruleForm.english = this.ruleForm.english + ' ' + this.ruleForm.englishTemp[i] + ' ' + this.ruleForm.scores[this.ruleForm.englishTemp[i]]
          }
          axios.post('http://localhost:8080/save', this.ruleForm).then(resp => {
            if (resp.data === 'success') {
              this.$alert('追加成功', 'メッセージ', {
                confirmButtonText: '确定',
                callback: action => {
                  this.$router.push('/StudentInformation')
                }
              })
            }
          })
        } else {
          return false
        }
      })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    }
  }
}
</script>
