<template>
    <v-card outlined>
        <v-card-title>
            RequestProduction
        </v-card-title>

        <v-card-text>
            <String label="ProductionId" v-model="value.productionId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="requestProduction"
            >
                RequestProduction
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'RequestProductionCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.productionId = '';
        },
        watch: {
        },
        methods: {
            requestProduction() {
                this.$emit('requestProduction', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

