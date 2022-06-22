<template>
  <div>
    <el-table
      :data="tableData"
      border
      style="width: 100%">
      <el-table-column
        fixed
        prop="name"
        label="姓名"
        width="100">
      </el-table-column>
      <el-table-column
        prop="status"
        label="状態"
        width="80">
      </el-table-column>
      <el-table-column
        prop="classTeacher"
        label="担任先生"
        width="100">
      </el-table-column>
      <el-table-column
        prop="birthday"
        label="生年月日"
        :formatter = "dateFormat"
        width="120">
      </el-table-column>
      <el-table-column
        prop="phone"
        label="電話番号"
        width="120">
      </el-table-column>
      <el-table-column
        prop="qq"
        label="QQ番号"
        width="120">
      </el-table-column>
      <el-table-column
        prop="entryDate"
        label="入塾時間"
        :formatter = "dateFormat"
        width="120">
      </el-table-column>
      <el-table-column
        prop="graduateDate"
        label="卒業時間"
        :formatter = "dateFormat"
        width="120">
      </el-table-column>
      <el-table-column
        prop="graduateSchool"
        label="卒業学校"
        width="120">
      </el-table-column>
      <el-table-column
        prop="major"
        label="卒業専攻"
        width="120">
      </el-table-column>
      <el-table-column
        prop="japanese"
        label="日本語成績"
        width="120">
      </el-table-column>
      <el-table-column
        prop="english"
        label="英語成績"
        width="120">
      </el-table-column>
      <el-table-column
        prop="note"
        label="メモ"
        width="100">
      </el-table-column>
      <el-table-column
        label="操作"
        width="100">
        <template v-slot="scope">
          <el-button @click="edit(scope.row)" type="text" size="small">編集</el-button>
          <el-button @click="deleteStudent(scope.row)" type="text" size="small">削除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      background
      @current-change="page"
      :page-size= "5"
      layout="total, prev, pager, next"
      :total="total">
    </el-pagination>
  </div>
</template>

<script>
import axios from 'axios'
import fecha from 'fecha'

export default {
  inject: ['reload'],
  methods: {
    deleteStudent (row) {
      this.$confirm('この操作はデータを完全に削除します。続行しますか?', '注意', {
        confirmButtonText: '确定',
        cancelButtonText: 'キャンセル',
        type: 'warning'
      }).then(() => {
        axios.delete('http://localhost:8080/deleteById/' + row.id).then(resp => {
          this.$message({
            type: 'success',
            message: '削除成功!'
          })
          this.reload()
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '削除操作がキャンセルされました。'
        })
      })
    },
    edit (row) {
      this.$router.push({
        path: '/update',
        query: {
          id: row.id
        }
      })
    },
    page (currentPage) {
      axios.get('http://localhost:8080/findAll/' + currentPage + '/5').then(resp => {
        this.tableData = resp.data.content
        this.total = resp.data.totalElements
      })
    },
    dateFormat (row, column, cellValue) {
      return cellValue ? fecha.format(new Date(cellValue), 'YYYY-MM-DD') : ''
    }
  },
  created () {
    axios.get('http://localhost:8080/findAll/1/5').then(resp => {
      this.tableData = resp.data.content
      this.total = resp.data.totalElements
      console.log(resp.data)
    })
  },
  data () {
    return {
      total: null,
      tableData: null
    }
  }
}
</script>
