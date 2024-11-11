<template>
    <v-card outlined>
        <v-card-title>
            CreateProductionPlan
        </v-card-title>

        <v-card-text>
            <String label="ProductId" v-model="value.productId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createProductionPlan"
            >
                CreateProductionPlan
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
        name: 'CreateProductionPlanCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.productId = '';
        },
        watch: {
        },
        methods: {
            createProductionPlan() {
                this.$emit('createProductionPlan', this.value);
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

