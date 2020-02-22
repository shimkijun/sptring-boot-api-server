<template>
  <div>
    <v-text-field
      :value="value"
      :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
      :rules="passwordRules"
      :type="show ? 'text' : 'password'"
      name="input-10-1"
      label="비밀번호 입력"
      hint="8글자이상 12자 이하"
      counter
      required
      outlined
      @click:append="show = !show"
      @input="$emit('input',$event)"
    />
  </div>
</template>
<script>
export default {
    props:{
        value:{
            type : String,
            required: true
        }
    },
    data(){
        return {
            show: false,
            passwordRules: [
                v => !!v || '비밀번호를 입력하세요',
                v => (v && v.length <= 12) || '비밀번호는 12자리 이하 입니다.',
                v => (v && v.length >= 8) || '비밀번호는 8자리 이상 입니다.',
            ]
        }
    }
}
</script>
