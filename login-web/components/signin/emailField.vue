<template>
  <div>
    <v-text-field
      :value="value"
      :rules="emailRules"
      label="이메일 입력"
      required
      outlined
      @input="$emit('input',$event)"
    />
  </div>
</template>
<script>
export default {
  props: {
    value: {
      type: String,
      required: true
    }
  },
  data(){
      return {
          emailRules: [
              v => !!v || '이메일을 입력하세요',
              v => /.+@.+\..+/.test(v) || '이메일 형식이 잘못되었습니다.',
          ]
      }
  },
}
</script>
<style>
  .v-text-field{
    margin-bottom:0 !important
  }
</style>