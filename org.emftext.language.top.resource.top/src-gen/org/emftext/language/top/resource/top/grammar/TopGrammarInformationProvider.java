/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.grammar;

public class TopGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static TopGrammarInformationProvider INSTANCE = new TopGrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_0_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getExpr().getEStructuralFeature(org.emftext.language.top.TopPackage.EXPR__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getExprChild(), }, 0);
	public final static org.emftext.language.top.resource.top.grammar.TopKeyword TOP_0_0_0_1_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopKeyword(",", org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_0_0_0_1_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getExpr().getEStructuralFeature(org.emftext.language.top.TopPackage.EXPR__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getExprChild(), }, 0);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_0_0_0_1_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_0_0_0_1_0_0_0, TOP_0_0_0_1_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_0_0_0_1_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_0_0_0_1_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopCompound TOP_0_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopCompound(TOP_0_0_0_1_0, org.emftext.language.top.resource.top.grammar.TopCardinality.STAR);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_0_0_0_0, TOP_0_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_0_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_0_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopRule TOP_0 = new org.emftext.language.top.resource.top.grammar.TopRule(org.emftext.language.top.TopPackage.eINSTANCE.getExpr(), TOP_0_0, org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_1_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getA().getEStructuralFeature(org.emftext.language.top.TopPackage.A__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getAChild(), }, 1);
	public final static org.emftext.language.top.resource.top.grammar.TopKeyword TOP_1_0_0_1_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopKeyword("a", org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_1_0_0_1_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getA().getEStructuralFeature(org.emftext.language.top.TopPackage.A__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getAChild(), }, 0);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_1_0_0_1_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_1_0_0_1_0_0_0, TOP_1_0_0_1_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_1_0_0_1_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_1_0_0_1_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopCompound TOP_1_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopCompound(TOP_1_0_0_1_0, org.emftext.language.top.resource.top.grammar.TopCardinality.PLUS);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_1_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_1_0_0_0, TOP_1_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_1_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_1_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopRule TOP_1 = new org.emftext.language.top.resource.top.grammar.TopRule(org.emftext.language.top.TopPackage.eINSTANCE.getA(), TOP_1_0, org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_2_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getB().getEStructuralFeature(org.emftext.language.top.TopPackage.B__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getBChild(), }, 1);
	public final static org.emftext.language.top.resource.top.grammar.TopKeyword TOP_2_0_0_1_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopKeyword("b", org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_2_0_0_1_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getB().getEStructuralFeature(org.emftext.language.top.TopPackage.B__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getBChild(), }, 0);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_2_0_0_1_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_2_0_0_1_0_0_0, TOP_2_0_0_1_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_2_0_0_1_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_2_0_0_1_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopCompound TOP_2_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopCompound(TOP_2_0_0_1_0, org.emftext.language.top.resource.top.grammar.TopCardinality.PLUS);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_2_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_2_0_0_0, TOP_2_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_2_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_2_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopRule TOP_2 = new org.emftext.language.top.resource.top.grammar.TopRule(org.emftext.language.top.TopPackage.eINSTANCE.getB(), TOP_2_0, org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_3_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getC().getEStructuralFeature(org.emftext.language.top.TopPackage.C__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getCChild(), }, 1);
	public final static org.emftext.language.top.resource.top.grammar.TopKeyword TOP_3_0_0_1_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopKeyword("c", org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_3_0_0_1_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getC().getEStructuralFeature(org.emftext.language.top.TopPackage.C__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getCChild(), }, 0);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_3_0_0_1_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_3_0_0_1_0_0_0, TOP_3_0_0_1_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_3_0_0_1_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_3_0_0_1_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopCompound TOP_3_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopCompound(TOP_3_0_0_1_0, org.emftext.language.top.resource.top.grammar.TopCardinality.PLUS);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_3_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_3_0_0_0, TOP_3_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_3_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_3_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopRule TOP_3 = new org.emftext.language.top.resource.top.grammar.TopRule(org.emftext.language.top.TopPackage.eINSTANCE.getC(), TOP_3_0, org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_4_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getD().getEStructuralFeature(org.emftext.language.top.TopPackage.D__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getDChild(), }, 1);
	public final static org.emftext.language.top.resource.top.grammar.TopKeyword TOP_4_0_0_1_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopKeyword("d", org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_4_0_0_1_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getD().getEStructuralFeature(org.emftext.language.top.TopPackage.D__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getDChild(), }, 0);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_4_0_0_1_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_4_0_0_1_0_0_0, TOP_4_0_0_1_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_4_0_0_1_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_4_0_0_1_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopCompound TOP_4_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopCompound(TOP_4_0_0_1_0, org.emftext.language.top.resource.top.grammar.TopCardinality.PLUS);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_4_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_4_0_0_0, TOP_4_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_4_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_4_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopRule TOP_4 = new org.emftext.language.top.resource.top.grammar.TopRule(org.emftext.language.top.TopPackage.eINSTANCE.getD(), TOP_4_0, org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_5_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getE().getEStructuralFeature(org.emftext.language.top.TopPackage.E__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getEChild(), }, 1);
	public final static org.emftext.language.top.resource.top.grammar.TopKeyword TOP_5_0_0_1_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopKeyword("e", org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_5_0_0_1_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getE().getEStructuralFeature(org.emftext.language.top.TopPackage.E__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getEChild(), }, 0);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_5_0_0_1_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_5_0_0_1_0_0_0, TOP_5_0_0_1_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_5_0_0_1_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_5_0_0_1_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopCompound TOP_5_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopCompound(TOP_5_0_0_1_0, org.emftext.language.top.resource.top.grammar.TopCardinality.PLUS);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_5_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_5_0_0_0, TOP_5_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_5_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_5_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopRule TOP_5 = new org.emftext.language.top.resource.top.grammar.TopRule(org.emftext.language.top.TopPackage.eINSTANCE.getE(), TOP_5_0, org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_6_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getF().getEStructuralFeature(org.emftext.language.top.TopPackage.F__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getFChild(), }, 1);
	public final static org.emftext.language.top.resource.top.grammar.TopKeyword TOP_6_0_0_1_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopKeyword("f", org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_6_0_0_1_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getF().getEStructuralFeature(org.emftext.language.top.TopPackage.F__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getFChild(), }, 0);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_6_0_0_1_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_6_0_0_1_0_0_0, TOP_6_0_0_1_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_6_0_0_1_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_6_0_0_1_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopCompound TOP_6_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopCompound(TOP_6_0_0_1_0, org.emftext.language.top.resource.top.grammar.TopCardinality.PLUS);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_6_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_6_0_0_0, TOP_6_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_6_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_6_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopRule TOP_6 = new org.emftext.language.top.resource.top.grammar.TopRule(org.emftext.language.top.TopPackage.eINSTANCE.getF(), TOP_6_0, org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_7_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getG().getEStructuralFeature(org.emftext.language.top.TopPackage.G__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getGChild(), }, 1);
	public final static org.emftext.language.top.resource.top.grammar.TopKeyword TOP_7_0_0_1_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopKeyword("g", org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_7_0_0_1_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getG().getEStructuralFeature(org.emftext.language.top.TopPackage.G__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getGChild(), }, 0);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_7_0_0_1_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_7_0_0_1_0_0_0, TOP_7_0_0_1_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_7_0_0_1_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_7_0_0_1_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopCompound TOP_7_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopCompound(TOP_7_0_0_1_0, org.emftext.language.top.resource.top.grammar.TopCardinality.PLUS);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_7_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_7_0_0_0, TOP_7_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_7_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_7_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopRule TOP_7 = new org.emftext.language.top.resource.top.grammar.TopRule(org.emftext.language.top.TopPackage.eINSTANCE.getG(), TOP_7_0, org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_8_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getH().getEStructuralFeature(org.emftext.language.top.TopPackage.H__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getHChild(), }, 1);
	public final static org.emftext.language.top.resource.top.grammar.TopKeyword TOP_8_0_0_1_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopKeyword("h", org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_8_0_0_1_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getH().getEStructuralFeature(org.emftext.language.top.TopPackage.H__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getHChild(), }, 0);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_8_0_0_1_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_8_0_0_1_0_0_0, TOP_8_0_0_1_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_8_0_0_1_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_8_0_0_1_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopCompound TOP_8_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopCompound(TOP_8_0_0_1_0, org.emftext.language.top.resource.top.grammar.TopCardinality.PLUS);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_8_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_8_0_0_0, TOP_8_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_8_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_8_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopRule TOP_8 = new org.emftext.language.top.resource.top.grammar.TopRule(org.emftext.language.top.TopPackage.eINSTANCE.getH(), TOP_8_0, org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_9_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getI().getEStructuralFeature(org.emftext.language.top.TopPackage.I__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getIChild(), }, 1);
	public final static org.emftext.language.top.resource.top.grammar.TopKeyword TOP_9_0_0_1_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopKeyword("i", org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_9_0_0_1_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getI().getEStructuralFeature(org.emftext.language.top.TopPackage.I__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getIChild(), }, 0);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_9_0_0_1_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_9_0_0_1_0_0_0, TOP_9_0_0_1_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_9_0_0_1_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_9_0_0_1_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopCompound TOP_9_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopCompound(TOP_9_0_0_1_0, org.emftext.language.top.resource.top.grammar.TopCardinality.PLUS);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_9_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_9_0_0_0, TOP_9_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_9_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_9_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopRule TOP_9 = new org.emftext.language.top.resource.top.grammar.TopRule(org.emftext.language.top.TopPackage.eINSTANCE.getI(), TOP_9_0, org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_10_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getJ().getEStructuralFeature(org.emftext.language.top.TopPackage.J__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getJChild(), }, 1);
	public final static org.emftext.language.top.resource.top.grammar.TopKeyword TOP_10_0_0_1_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopKeyword("j", org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_10_0_0_1_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getJ().getEStructuralFeature(org.emftext.language.top.TopPackage.J__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getJChild(), }, 0);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_10_0_0_1_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_10_0_0_1_0_0_0, TOP_10_0_0_1_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_10_0_0_1_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_10_0_0_1_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopCompound TOP_10_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopCompound(TOP_10_0_0_1_0, org.emftext.language.top.resource.top.grammar.TopCardinality.PLUS);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_10_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_10_0_0_0, TOP_10_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_10_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_10_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopRule TOP_10 = new org.emftext.language.top.resource.top.grammar.TopRule(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), TOP_10_0, org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_11_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getK().getEStructuralFeature(org.emftext.language.top.TopPackage.K__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getKChild(), }, 1);
	public final static org.emftext.language.top.resource.top.grammar.TopKeyword TOP_11_0_0_1_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopKeyword("k", org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopContainment TOP_11_0_0_1_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopContainment(org.emftext.language.top.TopPackage.eINSTANCE.getK().getEStructuralFeature(org.emftext.language.top.TopPackage.K__CHILD), org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.language.top.TopPackage.eINSTANCE.getKChild(), }, 0);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_11_0_0_1_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_11_0_0_1_0_0_0, TOP_11_0_0_1_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_11_0_0_1_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_11_0_0_1_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopCompound TOP_11_0_0_1 = new org.emftext.language.top.resource.top.grammar.TopCompound(TOP_11_0_0_1_0, org.emftext.language.top.resource.top.grammar.TopCardinality.PLUS);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_11_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_11_0_0_0, TOP_11_0_0_1);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_11_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_11_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopRule TOP_11 = new org.emftext.language.top.resource.top.grammar.TopRule(org.emftext.language.top.TopPackage.eINSTANCE.getK(), TOP_11_0, org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	public final static org.emftext.language.top.resource.top.grammar.TopPlaceholder TOP_12_0_0_0 = new org.emftext.language.top.resource.top.grammar.TopPlaceholder(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral().getEStructuralFeature(org.emftext.language.top.TopPackage.INTEGER_LITERAL__VALUE), "INTEGER_LITERAL", org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, 0);
	public final static org.emftext.language.top.resource.top.grammar.TopSequence TOP_12_0_0 = new org.emftext.language.top.resource.top.grammar.TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_12_0_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopChoice TOP_12_0 = new org.emftext.language.top.resource.top.grammar.TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality.ONE, TOP_12_0_0);
	public final static org.emftext.language.top.resource.top.grammar.TopRule TOP_12 = new org.emftext.language.top.resource.top.grammar.TopRule(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), TOP_12_0, org.emftext.language.top.resource.top.grammar.TopCardinality.ONE);
	
	public static String getSyntaxElementID(org.emftext.language.top.resource.top.grammar.TopSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (java.lang.reflect.Field field : org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.class.getFields()) {
			Object fieldValue;
			try {
				fieldValue = field.get(null);
				if (fieldValue == syntaxElement) {
					String id = field.getName();
					return id;
				}
			} catch (Exception e) { }
		}
		return null;
	}
	
	public static org.emftext.language.top.resource.top.grammar.TopSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (org.emftext.language.top.resource.top.grammar.TopSyntaxElement) org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static org.emftext.language.top.resource.top.grammar.TopRule[] RULES = new org.emftext.language.top.resource.top.grammar.TopRule[] {
		TOP_0,
		TOP_1,
		TOP_2,
		TOP_3,
		TOP_4,
		TOP_5,
		TOP_6,
		TOP_7,
		TOP_8,
		TOP_9,
		TOP_10,
		TOP_11,
		TOP_12,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public java.util.Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new java.util.LinkedHashSet<String>();
			for (org.emftext.language.top.resource.top.grammar.TopRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(org.emftext.language.top.resource.top.grammar.TopSyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof org.emftext.language.top.resource.top.grammar.TopKeyword) {
			keywords.add(((org.emftext.language.top.resource.top.grammar.TopKeyword) element).getValue());
		} else if (element instanceof org.emftext.language.top.resource.top.grammar.TopBooleanTerminal) {
			keywords.add(((org.emftext.language.top.resource.top.grammar.TopBooleanTerminal) element).getTrueLiteral());
			keywords.add(((org.emftext.language.top.resource.top.grammar.TopBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof org.emftext.language.top.resource.top.grammar.TopEnumerationTerminal) {
			org.emftext.language.top.resource.top.grammar.TopEnumerationTerminal terminal = (org.emftext.language.top.resource.top.grammar.TopEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (org.emftext.language.top.resource.top.grammar.TopSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
