<template>
  <v-row align="center">
    <v-form
      ref="form"
      v-model="valid"
      :lazy-validation="lazy"
    >
      <v-text-field
        v-model="email"
        :rules="emailRules"
        label="E-mail"
        required
      />

      <v-text-field
        v-model="password"
        :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
        :rules="passwordRules"
        :type="show ? 'text' : 'password'"
        name="input-10-1"
        label="Normal with hint text"
        hint="At least 8 characters"
        counter
        @click:append="show = !show"
      />

      <v-btn
        :disabled="!valid"
        color="success"
        class="mr-4"
        @click="validate"
      >
        로그인
      </v-btn>
    </v-form>
  </v-row>
</template>

<script>
  export default {
    data (){
        return {
            show: false,
            valid: true,
            password: '',
            passwordRules: [
                v => !!v || '비밀번호를 입력하세요',
                v => (v && v.length <= 12) || '비밀번호는 12자리 이하 입니다.',
                v => (v && v.length >= 8) || '비밀번호는 8자리 이상 입니다.',
            ],
            email: '',
            emailRules: [
                v => !!v || '이메일을 입력하세요',
                v => /.+@.+\..+/.test(v) || '이메일 형식이 잘못되었습니다.',
            ],
            select: null,
            lazy: false,
        }
    },
    methods: {

      validate () {
            if (this.$refs.form.validate()) {
            this.snackbar = true
            }
            this.$axios.post('/api/login/session',{
                email : this.email,
                password : this.password,
            })
            .then((res) => {
                console.log(res)
            })
            .catch((error) => {
                console.error(error)
            })
            
        },
      reset () {
        this.$refs.form.reset()
      },
      
    },
  }
</script>