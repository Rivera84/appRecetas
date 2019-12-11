package com.example.apprecetas

class Json(val hits: List<Hits>,
           val q: String,
           val more: Boolean,
           val count: Int,
           val from: Int,
           val to: Int,
           val params: Params)

class Params(val sane: List<String>,
             val q: List<String>,
             val app_key: List<String>,
             val app_id: List<String>)

class Hits(val bookmarked: Boolean,
           val bought: Boolean,
           val recipe: Recipe)

class Recipe(val image: String,
            // val shareAs: String,
           //  val cautions: List<String>,
          //   val healthLabels: List<String>,
             val label: String
           //  val source: String,
          //   val calories: Double,
          //   val uri: String,
         //    val url: String,
        //     val totalNutrients: TotalNutrients,
          //   val dietLabels: List<String>,
          //   val yield: Double,
       //      val totalWeight: Double,
          //   val digest: List<Digest>,
          //   val ingredients: List<Ingredients>,
          //   val totalDaily: TotalDaily,
         //    val ingredientLines: List<String>
    )
/*
class TotalDaily(val VITB6A: VITB6A,
                 val VITC: VITC,
                 val CHOCDF: CHOCDF,
                 val K: K,
                 val VITD: VITD,
                 val P: P,
                 val CHOLE: CHOLE,
                 val ENERC_KCAL: ENERC_KCAL,
                 val FASAT: FASAT,
                 val VITK1: VITK1,
                 val MG: MG,
                 val RIBF: RIBF,
                 val CA: CA,
                 val FOL: FOL,
                 val NIA: NIA,
                 val THIA: THIA,
                 val FIBTG: FIBTG,
                 val VITB12: VITB12,
                 val TOCPHA: TOCPHA,
                 val PROCNT: PROCNT,
                 val NA: NA,
                 val ZN: ZN,
                 val VITA_RAE: VITA_RAE,
                 val FAT: FAT,
                 val FE: FE)

class VITB6A(val unit: String,
             val quantity: Double,
             val label: String)

class VITC(val unit: String,
           val quantity: Double,
           val label: String)

class CHOCDF(val unit: String,
             val quantity: Double,
             val label: String)

class K(val unit: String,
        val quantity: Double,
        val label: String)

class VITD(val unit: String,
           val quantity: Double,
           val label: String)

class P(val unit: String,
        val quantity: Double,
        val label: String)

class CHOLE(val unit: String,
            val quantity: Double,
            val label: String)

class ENERC_KCAL(val unit: String,
                 val quantity: Double,
                 val label: String)

class FASAT(val unit: String,
            val quantity: Double,
            val label: String)

class VITK1(val unit: String,
            val quantity: Double,
            val label: String)

class MG(val unit: String,
         val quantity: Double,
         val label: String)

class RIBF(val unit: String,
           val quantity: Double,
           val label: String)

class CA(val unit: String,
         val quantity: Double,
         val label: String)

class FOL(val unit: String,
          val quantity: Double,
          val label: String)

class NIA(val unit: String,
          val quantity: Double,
          val label: String)

class THIA(val unit: String,
           val quantity: Double,
           val label: String)

class FIBTG(val unit: String,
            val quantity: Double,
            val label: String)

class VITB12(val unit: String,
             val quantity: Double,
             val label: String)

class TOCPHA(val unit: String,
             val quantity: Double,
             val label: String)

class PROCNT(val unit: String,
             val quantity: Double,
             val label: String)

class NA(val unit: String,
         val quantity: Double,
         val label: String)

class ZN(val unit: String,
         val quantity: Double,
         val label: String)

class VITA_RAE(val unit: String,
               val quantity: Double,
               val label: String)

class FAT(val unit: String,
          val quantity: Double,
          val label: String)

class FE(val unit: String,
         val quantity: Double,
         val label: String)

class Digest(val schemaOrgTag: String,
             val sub: List<Sub>,
             val total: Double,
             val unit: String,
             val daily: Double,
             val hasRDI: Boolean,
             val label: String,
             val tag: String)

class Sub(val schemaOrgTag: String,
          val total: Double,
          val unit: String,
          val daily: Double,
          val hasRDI: Boolean,
          val label: String,
          val tag: String)

class TotalNutrients(val VITB6A: VITB6A,
                     val FAMS: FAMS,
                     val VITC: VITC,
                     val CHOCDF: CHOCDF,
                     val K: K,
                     val VITD: VITD,
                     val FATRN: FATRN,
                     val P: P,
                     val CHOLE: CHOLE,
                     val ENERC_KCAL: ENERC_KCAL,
                     val FASAT: FASAT,
                     val VITK1: VITK1,
                     val MG: MG,
                     val RIBF: RIBF,
                     val CA: CA,
                     val FAPU: FAPU,
                     val FOL: FOL,
                     val NIA: NIA,
                     val THIA: THIA,
                     val FIBTG: FIBTG,
                     val VITB12: VITB12,
                     val TOCPHA: TOCPHA,
                     val SUGAR: SUGAR,
                     val PROCNT: PROCNT,
                     val NA: NA,
                     val ZN: ZN,
                     val VITA_RAE: VITA_RAE,
                     val FAT: FAT,
                     val FE: FE)

class FAMS(val unit: String,
           val quantity: Double,
           val label: String)

class FATRN(val unit: String,
            val quantity: Double,
            val label: String)

class FAPU(val unit: String,
           val quantity: Double,
           val label: String)

class SUGAR(val unit: String,
            val quantity: Double,
            val label: String)

class Ingredients(val weight: Double,
                  val text: String)

*/